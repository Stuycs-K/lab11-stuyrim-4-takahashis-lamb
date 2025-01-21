[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

* Can play with a group of 3 different types of adventurers :white_check_mark:
* Can play against chosen number of adventurer opponents(1-3) :white_check_mark:
* Can use attack/special operations on your opponents :white_check_mark:
* Can use support operations on your team :white_check_mark:
* The program ends when the user chose to quit, or all enemies is defeated, or the entire party is defeated :question:
* Can display the results of the attack/special/support inside your border :question:
* Allow the user to choose names of ally adventurers :ballot_box_with_check:

## Adventurer Subclasses

### King

>* The king holds a trident, and it's special feature is using harvested energy from the sun.
>
>* **Attack:** The king stabs the opponent using his sharp trident. This decreases the sun energy by 4 and the opponent's health by 7 HP.
>* **Special Attack:** The king uses his stored sun energy and converts it into electric energy. He initiates a lightning blast, which decreases the sun energy by 20 and the opponent;s health by 15 HP.
>* **Support:** The king can harvest the sun's energy and heal himself. Increases player's HP by 5, and if used on a king, increases sun energy by 10.
>* **Max HP:** 50 HP

### Farmer

>* The farmer's special features are their berries, which they grow before battle.
>
>* **Attack:** The farmer can use their berries to poison their opponent. This decreases the berries by 2 and the opponent's health by 4.
>
>* **Special Attack:** The farmer can convert multiple poison berries into a
bomb that could potentially kill players. This decreases the farmer's berries by 7 and the opponent's health by 10 HP.
>
>* **Support:** The farmer also has berries that can be used to restore health with the seeds growing other berries. This increases the player's hp by 3, and if used on a farmer, increases the berries amount by 6.
>* **Max HP:** 30 HP


## Boss Subclass

### God

>* God that oversees the code kingdom with God points used for power.
>
>* **Attack:** Uses God points to suck the life out of opponents. Decreases points by 10 and the opponent's health by 12 HP.
>
>* **Special Attack:** Trades in God points for the Earth to suffer a devastating natural disaster. Decreases points by 35 and the opponent's health by 25 HP.
>
>* **Support:** Supports itself by increasing amount of God points by 10, health by 10 HP. Uses 4 God points to heal other adventurers by 10.
>* **Max HP:** 300 HP
