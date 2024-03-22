# CAR_TP2

TP 2 – Spring

Développement d' une application Spring de gestion d’agendas

#### Clarification

Bonjour Monsieur,

Comme je vous l'ai remonté ce matin, j'ai des problèmes à push mon travail avec ma machine. A chaque fois que j'essaie de push, j'ai une demande d'authentification qui revient à chaque fois et malgré le fait que je mette les bons identifiants ceci ne marche pas (J'ai également essayé avec le git de l'université , j'ai le meme probleme).

 Etant donné que le TP doit etre noté pour aujourd'hui, j'ai utilisé la machine d'un autre étudiant pour que je puisse tout de meme l'ajouter en attendant que ce problème soit reglé.

#### Update: 
J'arrive à commit à partir de ma machine personnelle

## Compte rendu final d'avancement:

### Itération 1 : Gestion des personnes

    Objectifs atteints :
        Développement d'une fonctionnalité permettant aux utilisateurs de créer un compte en fournissant des informations personnelles telles qu'un email, un mot de passe, un nom et un prénom.
        Mise en place d'un système de connexion permettant aux utilisateurs de s'identifier à l'aide de leur email et mot de passe.
        Implémentation d'une option de déconnexion, assurant une navigation sécurisée et personnelle.

### Itération 2 : Gestion des agendas

    Objectifs atteints :
        Création d'une fonctionnalité pour ajouter de nouveaux agendas au système.
        Affichage de la liste des agendas associés à chaque personne.

### Itération 3 : Gestion des événements

    Objectifs atteints :
        Ajout de la capacité à insérer et à supprimer des événements dans un agenda spécifique.

### Itération 4 : Impression des agendas

    Objectifs atteints :
        Développement d'une interface permettant d'afficher les événements d'un agenda d'une personne.

### Itération 5 : Protection des routes de l’application

    Objectifs atteints :
        Renforcement de la sécurité à travers la mise en place d'un système de protection des routes. Chaque agenda est désormais strictement associé à une personne, et l'accès aux fonctionnalités de gestion d'agendas est conditionné par la vérification de l'authentification de l'utilisateur. 

L'application est également faite de sorte que la gestion de la session est utilisée pour vérifier l'authentification de l'utilisateur avant d'autoriser l'accès aux fonctionnalités de gestion des agendas. Cela garantit que chaque agenda est strictement associé à son utilisateur, renforçant la sécurité et l'intégrité de l'application.