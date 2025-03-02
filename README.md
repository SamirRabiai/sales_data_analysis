# ETL Pipeline avec Talend, MySQL et Power BI

## 📌 Description du projet

Ce projet met en place un pipeline ETL utilisant **Talend** pour collecter, nettoyer et alimenter une base de données **MySQL**. Les données de ventes et les données RH de l'entreprise sont ensuite exploitées via **Power BI**, qui se connecte à la base de données pour la visualisation et l'analyse des données.

## 📁 Structure du projet

```
/etl-pipeline-talend  
│── /talend_project/      # Contient le projet Talend complet  
│── /data/                # Données d’exemple (CSV, JSON, etc.)  
│── /docs/                # Documentation, images, schémas  
│── P&B_dashboard.pbix    # Fichier Power BI  
│── README.md             # Explication du projet  
```

## 🛠 Technologies utilisées

- **ETL** : Talend Open Studio
- **Base de données** : MySQL
- **Visualisation** : Power BI
- **Langages** : SQL

## 🔄 Architecture du pipeline ETL

📌 **Processus du pipeline** :

1. **Extraction** : Récupération des données sources (CSV, Excel, bases de données).
2. **Transformation** : Nettoyage et transformation des données avec Talend.
3. **Chargement** : Insertion des données transformées dans MySQL.
4. **Analyse** : Connexion de Power BI à la base MySQL pour visualiser les KPIs.

📌 **Schéma du pipeline** (ajouté dans `/docs/`)
![ETL](https://github.com/SamirRabiai/sales_data_analysis/blob/7bb1b5683a42721c79eb234c94c54aeec45d8dec/docs/Etl.png)
![Connexion et création des tables](https://github.com/user-attachments/assets/f52a7872-3e89-4ace-8e5a-dadabaa7b8a7)
![Extraction et aggrégation des ventes](https://github.com/SamirRabiai/sales_data_analysis/blob/7bb1b5683a42721c79eb234c94c54aeec45d8dec/docs/sales.png)


## 🚀 Installation et exécution

### 1️⃣ Prérequis

- Talend Open Studio installé
- MySQL Server installé
- Power BI Desktop installé

### 2️⃣ Installation

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/ton-profil/etl-pipeline-talend.git
   cd etl-pipeline-talend
   ```
2. **Importer le projet Talend** :
   - Ouvrir **Talend Open Studio**
   - Importer le projet depuis `/talend_project/`
3. **Configurer MySQL** :
   - Créer une base de données
   - Exécuter les scripts SQL fournis (si disponibles)
4. **Exécuter le pipeline ETL**
   - Lancer le job Talend pour traiter les données
5. **Ouvrir le fichier **``** dans Power BI**
   - Vérifier que la connexion à MySQL fonctionne

## 📊 Exemples de visualisations Power BI

![BI](https://github.com/SamirRabiai/sales_data_analysis/blob/f715362115b0458c866b8ecde1564d4cafd38d42/docs/pandb1.png)
![BI](https://github.com/SamirRabiai/sales_data_analysis/blob/f715362115b0458c866b8ecde1564d4cafd38d42/docs/pandb2.png)
![BI](https://github.com/SamirRabiai/sales_data_analysis/blob/f715362115b0458c866b8ecde1564d4cafd38d42/docs/pandb3.png)
![BI](https://github.com/SamirRabiai/sales_data_analysis/blob/f715362115b0458c866b8ecde1564d4cafd38d42/docs/pandb4.png)

## 🤝 Contribuer

Les contributions sont les bienvenues !

1. Fork le repo
2. Crée une branche feature (`git checkout -b nouvelle-feature`)
3. Commit tes changements (`git commit -m "Ajout d'une nouvelle feature"`)
4. Push sur GitHub (`git push origin nouvelle-feature`)
5. Crée une pull request


---



