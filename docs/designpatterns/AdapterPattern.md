# 📎 Adapter Pattern – Kort Forklaring

## 🔹 Idéen
Adapter-mønstret bruges, når du har en eksisterende klasse, der ikke matcher det interface, et nyt system forventer. 
I stedet for at ændre den gamle klasse, laver du en adapter, som oversætter mellem det gamle og det nye.

## 🔹 I praksis
Du laver en ny klasse (adapteren), som implementerer det ønskede interface og internt bruger den gamle klasse. 
Når systemet kalder metoder på det nye interface, videresender adapteren kaldet til de tilsvarende metoder i den gamle klasse.

## 🔹 Pointen
Adapter gør det muligt at genbruge eksisterende kode i nye sammenhænge, uden at ændre eller ødelægge den gamle kode. 
Det er en fleksibel og sikker måde at opnå kompatibilitet.

## 🔹 Virkelighedsnært
Adapter bruges ofte når:
- Et nyt system skal bruge et eksisterende bibliotek 📚
- Du arbejder med legacy-kode, som ikke kan ændres 🧓
- Du laver test og skal bruge mocks eller stubs med samme interface 🧪
