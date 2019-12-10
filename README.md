# PTS3

// Lors de la première utilisation d'un dossier avec git
git init

// Pour associer le git Local au gitHub (une seul fois suffit après création d'un nouveau git)
git remote add origin https://github.com/i182317/PTS3.git

// Pour changer de branch
git checkout nomDeLaBranche

// Pour créer une nouvelle branch
git branch nomDeLaBranche

// Pour mettre à jour notre git Local selon le gitHub
git pull origin nomDeLaBranche

// Pour ajouter les fichier qui on été modifier
git add .

// Pour faire la sauvegarde sur le git local
git commit -m "first commit"

// Pour envoyer la sauvegarde local sur gitHub
git push origin nomDeLaBranche
