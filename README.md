# 📉 Prédiction du churn – Tunisie Télécom

Projet de **Business Intelligence et Data Science** : prédire quels clients d'un opérateur télécom risquent de **quitter** leur abonnement (c'est le *churn*).

**Auteure :** Malak Saidani

---

## 📌 Sommaire

1. [Contexte et objectif](#-contexte-et-objectif)
2. [Contenu du dépôt](#-contenu-du-dépôt)
3. [Les données](#-les-données)
4. [Modèle en étoile (entrepôt de données)](#-modèle-en-étoile-entrepôt-de-données)
5. [ETL avec Talend](#-etl-avec-talend)
6. [Notebook de prédiction](#-notebook-de-prédiction)
7. [Résultats](#-résultats)
8. [Tableau de bord Power BI](#-tableau-de-bord-power-bi)
9. [Comment lancer le projet](#-comment-lancer-le-projet)
10. [Outils utilisés](#-outils-utilisés)
11. [Pistes d'amélioration](#-pistes-damélioration)

---

## 🎯 Contexte et objectif

Quand un client quitte son opérateur, l'entreprise perd de l'argent. Il coûte aussi plus cher de trouver un nouveau client que de garder un client actuel.

**Objectif :** utiliser les données des clients (appels, coûts, réclamations, satisfaction…) pour **prévoir qui va partir**, afin de pouvoir lui proposer une offre avant son départ.

Le projet suit 3 grandes étapes :

| Étape | Ce qu'on fait | Outil |
|---|---|---|
| 1. **ETL** | Nettoyer et préparer les données, puis les ranger dans un entrepôt de données | Talend + MySQL |
| 2. **Analyse et prédiction** | Étudier les données et entraîner des modèles de Machine Learning | Python (Jupyter) |
| 3. **Visualisation** | Montrer les résultats dans un tableau de bord | Power BI |

---

## 📁 Contenu du dépôt

```
churn-telecom/
├── talend/       Projet Talend (jobs ETL) + captures
├── data/         Données brutes et données après ETL
├── notebooks/    Notebook Jupyter de prédiction du churn
├── models/       Meilleur modèle sauvegardé (.pkl)
├── powerbi/      Tableau de bord (.pbix)
├── docs/         Schéma du modèle en étoile
├── requirements.txt
└── README.md
```

| Dossier / fichier | Description |
|---|---|
| `talend/CHURN/` | Projet Talend (les jobs ETL) |
| `talend/captures/` | Captures d'écran des jobs ETL et de leurs résultats |
| `data/dataset_telecom.csv` | Données **brutes** (5000 clients, 23 colonnes) |
| `data/dataset_telecom_apres_etl.xlsx` | Données **nettoyées** après ETL (5000 clients, 18 colonnes) |
| `notebooks/prediction_churn.ipynb` | Analyse des données + 4 modèles de prédiction |
| `models/meilleur_modele_churn.pkl` | Meilleur modèle, prêt à être réutilisé |
| `powerbi/tableau_de_bord.pbix` | Tableau de bord interactif |
| `docs/modele_en_etoile.png` | Schéma de l'entrepôt de données |
| `requirements.txt` | Liste des bibliothèques Python à installer |

---

## 🗂️ Les données

- **5000 clients**, un client par ligne.
- La colonne à prédire s'appelle **`churn`** : `1` = le client est parti, `0` = il est resté.
- Seulement **environ 14 %** des clients sont partis (707 sur 5000). Les classes sont donc **déséquilibrées**.

### Colonnes utilisées pour la prédiction

| Type | Colonnes |
|---|---|
| Abonnement | `nb_jours_abonne` |
| Appels de jour | `nb_appel_jour`, `duree_appel_jour_minutes`, `cout_appel_jour` |
| Appels de soirée | `nb_appel_soiree`, `duree_appel_soiree_minutes`, `cout_appel_soiree` |
| Appels de nuit | `nb_appel_nuit`, `duree_appel_nuit_minutes`, `cout_appel_nuit` |
| Appels internationaux | `nb_appel_inter`, `duree_appel_inter_minutes`, `cout_appel_inter` |
| Service client | `nb_msg_vocaux`, `nb_reclamation`, `Score_Satisfaction` |

### Qu'est-ce que l'ETL a changé ?

| Avant (fichier brut) | Après (fichier ETL) |
|---|---|
| Quelques valeurs manquantes | Aucune valeur manquante |
| Noms de colonnes avec accents et parenthèses (`durée_appel_jour(minutes)`) | Noms simples (`duree_appel_jour_minutes`) |
| `churn` écrit `True.` / `False.` | `churn` en `1` / `0` |
| Infos du client, de la ville et de la date dans la même table | Ces infos sont rangées dans des **tables de dimensions** (voir ci-dessous) |

---

## ⭐ Modèle en étoile (entrepôt de données)

Les données sont organisées en **étoile** : une grande table au centre (les faits) et des petites tables autour (les dimensions).

![Modèle en étoile](docs/modele_en_etoile.png)

| Table | Rôle | Contenu principal |
|---|---|---|
| `fact_churn_tt` | **Table de faits** (au centre) | Appels, coûts, réclamations, satisfaction, `churn` |
| `dim_client_tt` | Dimension client | Catégorie d'âge, état civil, messagerie vocale activée |
| `dim_localisation_tt` | Dimension localisation | Ville |
| `dim_temps_tt` | Dimension temps | Jour, mois, année |

Les tables sont reliées par des clés : `id_client`, `id_ville` et `id_date`.

---

## 🔄 ETL avec Talend

L'**ETL** (*Extract – Transform – Load*) sert à **extraire** les données du fichier CSV, les **transformer** (nettoyage) puis les **charger** dans l'entrepôt de données. Il a été réalisé avec **Talend**.

### Deux bases de données MySQL

| Base | Rôle |
|---|---|
| `bd_pfe1` | Base **intermédiaire** : elle stocke les données extraites du CSV (`table_source`), sert à nettoyer les mesures et à faire les jointures pour préparer la table de faits |
| `bd_pfe` | **Entrepôt de données** : elle contient les 3 dimensions et la table de faits |

### Les 5 jobs

| # | Job | Ce qu'il alimente |
|---|---|---|
| 1 | Job `dim_client_tt` | Table `dim_client_tt` |
| 2 | Job `dim_localisation` | Table `dim_localisation_tt` |
| 3 | Job `dim_temps_tt` | Table `dim_temps_tt` |
| 4 | Job `table_source` | Table `table_source` (données nettoyées, base `bd_pfe1`) |
| 5 | Job `fact_churn_tt` | Table de faits `fact_churn_tt` |

### Les composants Talend utilisés

| Composant | À quoi il sert |
|---|---|
| `tFileInput` (`dataset_telecom`) | Lire le fichier CSV source |
| `tMap` | Choisir les colonnes, faire des calculs, séparer les données en plusieurs flux |
| `tReplace` | Remplacer des valeurs (par exemple `True.` / `False.`) |
| `tConvertType` | Changer le type d'une colonne (par exemple `churn` en entier) |
| `tAggregateRow` | Calculer des sommes, des moyennes, des maximums ou des nombres d'occurrences |
| `tLogRow` | Afficher un résultat dans la console pour le contrôler |
| Composants de sortie MySQL | Écrire les données dans les tables |

### Job 1 : dimension client (`dim_client_tt`)

On lit le CSV, puis on le transforme avant de le charger dans `dim_client_tt`.

![Job dim_client_tt](talend/captures/01_job_dim_client_tt.png)

Le premier `tMap` crée **deux flux** :
- un flux qui **compte les valeurs nulles** des champs de la dimension (via `tAggregateRow` puis `tLogRow`) ;
- un flux qui **sélectionne les données** à charger dans la dimension.

![tMap 1 – dim_client](talend/captures/02_dim_client_tmap1.png)

Le deuxième flux passe ensuite par un `tReplace` qui **remplace les valeurs** du champ `Tranche d'âge`.

![tReplace – tranche d'âge](talend/captures/03_dim_client_treplace_tranche_age.png)

Un second `tMap` termine le traitement de `Tranche d'âge` et traite aussi le champ `active_msg_vocaux`. Les autres champs passent sans changement, puis tout est inséré dans `dim_client_tt`.

![tMap 2 – dim_client](talend/captures/04_dim_client_tmap2.png)

### Job 2 : dimension localisation (`dim_localisation`)

![Job dim_localisation](talend/captures/05_job_dim_localisation.png)

Le `tMap` crée aussi **deux flux** :
- un flux qui compte les valeurs nulles du champ `Ville` ;
- un flux qui sélectionne les villes et **ajoute `id_ville`** avec un **auto-incrément** (1, 2, 3…).

![tMap 1 – dim_localisation](talend/captures/06_dim_localisation_tmap1.png)

### Job 3 : dimension temps (`dim_temps_tt`)

À partir de la date d'activation, le `tMap` **extrait le jour, le mois et l'année**. L'identifiant de date est **généré automatiquement**.

![Job dim_temps_tt](talend/captures/07_job_dim_temps_tt.png)

![tMap 1 – dim_temps](talend/captures/08_dim_temps_tmap1.png)

### Job 4 : table source (nettoyage des mesures)

C'est le job de **nettoyage principal**. Il lit le CSV, nettoie les données, convertit un type, puis charge la table `table_source`.

![Job table_source](talend/captures/09_job_table_source.png)

**Étape 1 – Transformer `churn`.** Un `tReplace` remplace les valeurs de `churn`, puis un `tConvertType` le convertit en **entier** (`1` / `0`).

![tReplace – churn](talend/captures/10_table_source_treplace_churn.png)

**Étape 2 – Traiter les valeurs nulles.** Un `tMap` utilise **4 flux** :

| Flux | Ce qu'il fait |
|---|---|
| 1 | `tAggregateRow 1` **compte les valeurs nulles**, le résultat est affiché dans `tLogRow 1` |
| 2 | `tAggregateRow 2` compte le **nombre d'occurrences des réclamations** (`nb_reclamation`) |
| 3 | `tAggregateRow 3` calcule le **maximum et la moyenne** des champs qui ont des valeurs nulles (sauf `nb_reclamation`) |
| 4 | **Remplit les valeurs nulles** avec les résultats calculés dans les flux précédents |

![tMap 1 – table_source](talend/captures/11_table_source_tmap1.png)

Résultat du contrôle des valeurs nulles dans la console :

![Résultat valeurs nulles](talend/captures/12_table_source_resultat_valeurs_nulles.png)

Configuration du 4ᵉ flux (remplissage des valeurs nulles) :

![tMap – remplissage des nulls](talend/captures/13_table_source_tmap_remplissage_nulls.png)

### Job 5 : table de faits (`fact_churn_tt`)

Ce job charge la table de faits au centre de l'étoile.

![Job fact_churn_tt](talend/captures/14_job_fact_churn_tt.png)

### Résultat : tables chargées dans l'entrepôt

Après l'exécution des jobs, les tables sont bien remplies.

**`dim_client_tt`**

![dim_client_tt](talend/captures/15_resultat_dim_client_tt.png)

**`dim_localisation`**

![dim_localisation](talend/captures/16_resultat_dim_localisation.png)

**`dim_temps_tt`**

![dim_temps_tt](talend/captures/17_resultat_dim_temps_tt.png)

**`fact_churn_tt`**

![fact_churn_tt](talend/captures/18_resultat_fact_churn_tt.png)

---

## 📓 Notebook de prédiction

Fichier : [`notebooks/prediction_churn.ipynb`](notebooks/prediction_churn.ipynb)

Il est écrit en français, avec des explications simples avant chaque partie :

| # | Partie | Ce qu'on y fait |
|---|---|---|
| 1 | Objectif | Expliquer le problème |
| 2 | Bibliothèques | Importer les outils Python |
| 3 | Chargement | Lire les données après ETL |
| 4 | Exploration | Tailles, types, valeurs manquantes, doublons |
| 5 | Variable cible | Voir combien de clients sont partis |
| 6 | Analyse des variables | Graphiques, comparaison restés / partis, corrélations |
| 7 | Préparation | Séparer entraînement (80 %) et test (20 %) |
| 8 | Modélisation | Entraîner 4 modèles |
| 9 | Comparaison | Accuracy, précision, rappel, F1, AUC, courbes ROC |
| 10 | Courbes d'apprentissage | Vérifier que les modèles apprennent bien |
| 11 | Importance des variables | Voir ce qui influence le plus le churn |
| 12 | Sauvegarde | Enregistrer le meilleur modèle et l'utiliser sur des exemples |
| 13 | Conclusion | Résumer ce qu'on a appris |

### Les 4 modèles testés

| Modèle | Idée simple |
|---|---|
| **Régression logistique** | Calcule une probabilité de départ avec une formule |
| **KNN** | Regarde les clients les plus proches (le meilleur `k` est cherché automatiquement) |
| **Arbre de décision** | Pose une suite de questions oui/non (la meilleure profondeur est cherchée avec `GridSearchCV`) |
| **Forêt aléatoire** | Beaucoup d'arbres qui votent ensemble |

### Bonnes pratiques utilisées

- **Séparation stratifiée** : la proportion de clients partis (~14 %) est la même dans l'entraînement et dans le test.
- **Pipeline avec standardisation** : l'échelle des variables est apprise uniquement sur l'entraînement (pas de fuite d'information vers le test).
- **Plusieurs métriques** : comme les classes sont déséquilibrées, on ne regarde pas seulement l'accuracy.

---

## 🏆 Résultats

Scores sur le jeu de test (1000 clients) :

| Modèle | Accuracy | Précision | Rappel | F1-score | AUC |
|---|---|---|---|---|---|
| **Forêt aléatoire** | **0.931** | **0.919** | **0.560** | **0.696** | **0.875** |
| Arbre de décision | 0.913 | 0.829 | 0.482 | 0.610 | 0.820 |
| KNN | 0.891 | 0.742 | 0.348 | 0.473 | 0.764 |
| Régression logistique | 0.866 | 0.621 | 0.128 | 0.212 | 0.757 |

> Les résultats peuvent varier très légèrement selon la version des bibliothèques.

### Comment lire ces scores ?

- **Accuracy** : part des prédictions correctes.
- **Précision** : quand le modèle dit « ce client va partir », il a raison dans 92 % des cas (forêt aléatoire).
- **Rappel** : parmi les clients qui sont vraiment partis, le modèle en retrouve environ 56 %.
- **AUC** : capacité à séparer les clients qui partent de ceux qui restent (0.5 = hasard, 1 = parfait).

### Ce qu'on retient

- ✅ La **forêt aléatoire** est le meilleur modèle sur ces données.
- ⚠️ L'accuracy seule est trompeuse : un modèle qui dirait toujours « le client reste » aurait déjà environ 86 %. C'est pour cela qu'on regarde aussi le rappel et le F1-score.
- 🔑 Les variables sur les **réclamations**, la **satisfaction** et l'**usage des appels** aident le plus à repérer un client à risque (voir le graphique d'importance dans le notebook).

---

## 📊 Tableau de bord Power BI

Fichier : [`powerbi/tableau_de_bord.pbix`](powerbi/tableau_de_bord.pbix)

Le tableau de bord présente les indicateurs (KPI) sur le churn. Pour l'ouvrir, il faut **Power BI Desktop** (gratuit, Windows).

---

## 🚀 Comment lancer le projet

### 1. Télécharger le projet

```bash
git clone https://github.com/MalakSaidani26/churn-telecom.git
cd churn-telecom
```

### 2. Installer les bibliothèques

```bash
pip install -r requirements.txt
```

### 3. Ouvrir le notebook

```bash
cd notebooks
jupyter notebook prediction_churn.ipynb
```

Puis choisir **Cell → Run All** pour tout exécuter.

> ℹ️ Le notebook doit être lancé **depuis le dossier `notebooks/`**, car il lit les données avec le chemin `../data/`.

### 4. Utiliser le modèle sauvegardé (sans ré-entraîner)

```python
import joblib
import pandas as pd

modele = joblib.load("models/meilleur_modele_churn.pkl")

# clients = DataFrame avec les 16 colonnes de prédiction (voir le tableau des colonnes)
probabilite_depart = modele.predict_proba(clients)[:, 1]
```

---

## 🛠️ Outils utilisés

| Domaine | Outils |
|---|---|
| ETL | Talend |
| Entrepôt de données | Modèle en étoile (MySQL) |
| Analyse et Machine Learning | Python, pandas, NumPy, scikit-learn |
| Graphiques | Matplotlib, Seaborn |
| Tableau de bord | Power BI |
| Notebook | Jupyter |



## 👩‍💻 Auteure

**Malak Saidani**
🔗 [LinkedIn](https://www.linkedin.com/in/malak-saidani-019b68334) · 🐙 [GitHub](https://github.com/MalakSaidani26)
