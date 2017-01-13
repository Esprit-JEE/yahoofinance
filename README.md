# yahoofinance

URL de yahoo :
https://developer.yahoo.com/yql/console/?q=show%20tables&env=store://datatables.org/alltableswithkeys#h=select+*+from+yahoo.finance.xchange+where+pair+in+(%22USD%22%2C+%22EUR%22)

liens utiles :
http://theoryapp.com/parse-json-in-java/
https://jsonformatter.curiousconcept.com/

*Sans Maven:
utiliser un IDE
Ajouter manuellement httpclient-4.1.1.jar et json-20160810.jar et leur dépendances si nécessaire

*Avec Maven
mvn clean compile exec:java