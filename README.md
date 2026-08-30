# Implementering av CLI
Programmets syfte är en simpel CLI elpris-analysator.
Man ska kunna välja mellan 4st el-områden.
Sortera priser från lågt till högt
Samt genomsnittligt elpris
Samt bästa 4h intervall att ladda diverse apparater.

Programmet är uppdelat i flera klasser för att separera olika ansvarsområden.

**Main** hanterar menyn, användarinput och API-anropet

**ElectricityPrice** används som modell för prisdatan från API:t
Gson används för att omvandla JSON-datan till Java-objekt.

**PriceAnalyzer** innehåller logiken för att analysera och sortera priserna.

=========================================

# Reflektion
Då jag endast kodat med Javascript tidigare så är jämförelsen direkt mot det språket.
Java som språk känns mer strukturerat, man måste vara tydligare med tex datatyper och vilka exceptions som kan uppstå. 
Nu har jag inte grottat ned mig mycket i felhantering för detta projekt men under min research för projektet hittade jag
mycket bra info om hur felhantering kan implementeras och hur tydligt det är för den som läser koden.

Det känns som att man behöver mer kod än i Javascript men samtidigt så blir kodningen och språket tydligare.
Det är nog en produkt av att jag kodat 1 år redan men känner att Java som språk är tydligare och lättare att lära sig.

Uppgiften i sig har gett mig en grundläggande förståelse för hur Java arbetar med API-anrop, JSON parsing, arrayer, objekt osv.
Det är tidigt att säga men jag tycker att Java i jämförelse mot Javascript har sina för och nackdelar, har ingen preferens just nu.
