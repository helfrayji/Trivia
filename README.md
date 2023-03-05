Pour exécuter les tests, vous pouvez utiliser un outil de construction comme Maven ou Gradle, ou les exécuter directement depuis votre IDE. Les tests utilisent JUnit 5, assurez-vous donc que les dépendances appropriées sont installées.

Les tests : 
isPlayable_shouldReturnFalseWhenNoPlayers()
Ce test garantit que isPlayable renvoie false lorsqu'il n'y a aucun joueur dans la partie.

isPlayable_shouldReturnFalseWhenOnePlayer()
Ce test garantit que isPlayable renvoie false lorsqu'il n'y a qu'un seul joueur dans la partie.

isPlayable_shouldReturnTrueWhenTwoPlayers()
Ce test garantit que isPlayable renvoie true lorsqu'il y a deux joueurs dans la partie.

addPlayer_shouldIncreaseNumPlayers()
Ce test garantit que addPlayer augmente le nombre de joueurs dans le jeu.

addPlayer_shouldSetPlayerPositionAndScore()
Ce test garantit que addPlayer définit la position initiale et le score de chaque joueur ajouté au jeu.

addPlayer_shouldSetPlayerInPenaltyBoxToFalse()
Ce test garantit que addPlayer définit l'indicateur playersInPenaltyBox sur false pour chaque joueur ajouté au jeu.

roll_shouldUpdatePlayerPosition()
Ce test garantit que le lancer met correctement à jour la position du joueur en fonction du lancer de dés.

roll_shouldWrapAroundWhenPlayerPositionExceeds11()
Ce test garantit que le roulis enveloppe correctement la position du joueur lorsqu'il dépasse 11.
