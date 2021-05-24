# sAPInet

Une librairie java pour obtenir différentes informations vis-à-vis des services de l'hébergeur Sapinet grâce à api.sapinet.fr !

## Installation

La dernière version disponible est : [![](https://jitpack.io/v/KeyKatyu/sAPInet.svg)](https://jitpack.io/#KeyKatyu/sAPInet)
La librarie est disponible sur JitPack.io, pour la récupérer dans votre projet veuillez suivre les instructions disponibles [ici](https://jitpack.io/#KeyKatyu/sAPInet/).

## Documentation

Pour utiliser [l'API de Sapinet](https://api.sapinet.fr) vous aurez besoin d'un **token**. Le(s) développeur(s) de sAPInet ne fournissent aucuns tokens, il vous faudra en faire la demande à l'équipe officielle de l'hébergeur.

**Initialisation :**
```
Sapinet sapinet = new Sapinet("Votre TOKEN");
```
**Récupérer les informations d'un seul service :**
```
Service serviceUn = sapinet.pingService(1);
```
**Récupérer les informations de tous les services :** (nécessite un token administrateur)
```
List<Service> services = sapinet.pingAllServices();
```

**Utiliser la classe Service :**
```
Service serviceDeTest = sapinet.pingService(2);

boolean isOnline = serviceDeTest.isOnline();
int serviceId = serviceDeTest.getServiceId();
int testPort = serviceDeTest.getTestPort();
String hostname = serviceDeTest.getHostname();
String name = serviceDeTest.getName();
String testType = serviceDeTest.getTestType();
```

## API IDs :
* VPS1 : 1
* VPS2 : 2
* VPS3 : 3
* VPS4 : 4
* VPS5 : 5
* VPS6 : 6
* VPS7 : 7
* Web : 8
* Network : 9
* Dedicated : 10
