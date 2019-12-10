# PTS3

// Lors de la première utilisation d'un dossier avec git\n
git init

// Pour associer le git Local au gitHub (une seul fois suffit après création d'un nouveau git)\n
git remote add origin https://github.com/i182317/PTS3.git

// Pour changer de branch\n
git checkout nomDeLaBranche

// Pour créer une nouvelle branch\n
git branch nomDeLaBranche

// Pour mettre à jour notre git Local selon le gitHub\n
git pull origin nomDeLaBranche

// Pour ajouter les fichier qui on été modifier\n
git add .

// Pour faire la sauvegarde sur le git local
git commit -m "first commit"

// Pour envoyer la sauvegarde local sur gitHub
git push origin nomDeLaBranche
