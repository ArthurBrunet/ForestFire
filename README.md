## ✅ Prérequis

- Java 17 ou plus : [Adoptium](https://adoptium.net/) ou [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven 3.8+ : [Installer Maven](https://maven.apache.org/install.html)
- Un IDE Java recommandé : IntelliJ IDEA, Eclipse, VSCode...

## 🔧 Installation

1. **Cloner le projet :**

   ```bash
   git clone https://github.com/ArthurBrunet/ForestFire.git
   cd ForestFire
2. **Construire le projet :**

   ```bash
   mvn clean install
3. **Lancer l'application :**

   ```bash
   mvn exec:java -Dexec.mainClass="org.forest.fire.Main"