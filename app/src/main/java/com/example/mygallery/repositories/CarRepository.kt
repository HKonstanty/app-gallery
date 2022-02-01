package com.example.mygallery.repositories

import com.example.mygallery.R
import com.example.mygallery.models.Car
import com.example.mygallery.models.Category

class CarRepository {
    companion object {
        var currentCar = ""
        var currentModel = ""
        val instance : CarRepository = CarRepository() // referencja do klasy CarRepository
    }

    private var dataSet : MutableList<Car> = mutableListOf()

    fun initialize() {
        dataSet.clear()
        dataSet.add(Car("Ferrari", Category.FERRARI, "812 Superfast", "800KM",
                "6.5L",  R.drawable.ferrari_812, "Ferrari 812 Superfast – samochód sportowy klasy wyższej produkowany pod włoską marką Ferrari od 2017 roku."))
        dataSet.add(Car("Ferrari", Category.FERRARI, "Monza SP1", "800KM",
                "6.5L", R.drawable.ferrari_monza, "Ferrari Monza SP1 są ograniczone do produkcji samochodów sportowych produkowanych przez włoski producent samochodów Ferrari."))
        dataSet.add(Car("Ferrari", Category.FERRARI, "LaFerrari", "800KM",
                "6.3L", R.drawable.ferrari_laferrari, "Ferrari LaFerrari – supersamochód segmentu F produkowany przez włoską markę Ferrari w latach 2013 – 2018."))
        dataSet.add(Car("Ferrari", Category.FERRARI, "458 Italia", "570KM",
                "4.5L", R.drawable.ferrari_458_italia, "Ferrari 458 Italia – supersamochód klasy średniej produkowany przez włoską markę Ferrari w latach 2009 – 2015."))
        dataSet.add(Car("Lamborghini", Category.LAMBORGHINI, "Gallardo", "500KM",
                "5.0L", R.drawable.lamborghini_gallardo, "Lamborghini Gallardo - supersamochód klasy średniej produkowany przez włoską markę Lamborghini w latach 2003 - 2013."))
        dataSet.add(Car("Lamborghini", Category.LAMBORGHINI, "Murcielago", "580KM",
                "6.2L", R.drawable.lamborghini_murcielago, "Pierwszy raz publicznie został pokazany we wrześniu 2001. Był pierwszym samochodem całkowicie wyprodukowanym po kupnie Lamborghini przez koncern Audi w 1998 roku. Od 2001 roku wyprodukowano 8 różnych wersji samochodu nie licząc limitowanej produkcji Reventóna. Wyprodukowano 4099 egzemplarzy modelu."))
        dataSet.add(Car("Lamborghini", Category.LAMBORGHINI, "Veneno", "750KM",
                "6.5L", R.drawable.lamborghini_veneno, "Pojazd został zaprezentowany podczas Międzynarodowej Wystawy Samochodowej w Genewie 8 marca 2013 roku. Veneno w języku hiszpańskim oznacza jad, truciznę, jak w różnych modelach Lamborghini została ona przyznana aby zapamiętać jednego z najbardziej znanych byków."))
        dataSet.add(Car("Aston Martin", Category.ASTON_MARTIN, "DBS Superleggera", "715KM",
                "5.2L", R.drawable.aston_martin_dbs_superleggera, "Aston Martin DBS Superleggera jest grand tourer produkowany przez producenta brytyjski luksusowy samochód Aston Martin od roku 2018. W czerwcu 2018 roku, Aston Martin zaprezentował samochód jako marque V12 flagowego grand tourer oparta na DB11 V12."))
        dataSet.add(Car("Aston Martin", Category.ASTON_MARTIN, "Valkyrie", "1013KM",
                "6.5L", R.drawable.aston_martin_valkyrie, "Valkyrie to pierwszy supersamochód najwyższej klasy zbudowany przez markę Aston Martin. Nazwa samochodu nawiązuje do określenia bogini Walkirie z mitologii nordyckiej. Samochód został skonstruowany razem z zespołem Red Bull Racing, na co dzień działającym w wyścigach Formuły 1."))
        dataSet.add(Car("Aston Martin", Category.ASTON_MARTIN, "Vulacan", "820KM",
                "7.0L", R.drawable.aston_martin_vulcan, "Aston Martin Vulcan jest dwudrzwiowa, dwumiejscowego, wysoka wydajność lekki utwór tylko samochód uruchomiony w 2015 roku przez brytyjskiego producenta luksusowych samochód Aston Martin w 2015 Geneva Motor Show ."))
    }

    fun getDataSet() : MutableList<Car> {
        return dataSet
    }

    fun getFerrari() : MutableList<Car> {
        val tempList: MutableList<Car> = mutableListOf()
        for (car in dataSet){
            if(car.category == Category.FERRARI)
                tempList.add(car)
        }
        return tempList
    }

    fun getLamborghini() : MutableList<Car> {
        val tempList: MutableList<Car> = mutableListOf()
        for (car in dataSet){
            if(car.category == Category.LAMBORGHINI)
                tempList.add(car)
        }
        return tempList
    }

    fun getAston() : MutableList<Car> {
        val tempList: MutableList<Car> = mutableListOf()
        for (car in dataSet){
            if(car.category == Category.ASTON_MARTIN)
                tempList.add(car)
        }
        return tempList
    }

    fun getFavourite() : MutableList<Car> {
        val tempList: MutableList<Car> = mutableListOf()
        for (car in dataSet){
            if(car.isFav) {
                tempList.add(car)
            }
        }
        return tempList
    }

    fun deleteCar(model: String) {
        val tempList: MutableList<Car> = mutableListOf()
        for (car in dataSet)
            if (car.model != model)
                tempList.add(car)
        dataSet = tempList
       /* for (car in dataSet){
            if(car.model == model) {
                dataSet.remove(car)
            }
        }*/
    }

    fun getInstance() : CarRepository {
        return instance
    }

    fun getCar(model: String): Car {
        for (car in dataSet) {
            if (car.model ==  model)
                return car
        }
        return dataSet[0]
    }

    fun getFotos(name: String): ArrayList<Int> {
        return when (name) {
            "Ferrari" -> arrayListOf(
                R.drawable.ferrari_458_italia,
                R.drawable.ferrari_812,
                R.drawable.ferrari_monza
            )
            "Lamborghini" -> arrayListOf(
                R.drawable.lamborghini_gallardo,
                R.drawable.lamborghini_murcielago,
                R.drawable.lamborghini_veneno
            )
            else -> return arrayListOf(
                R.drawable.aston_martin_valkyrie,
                R.drawable.aston_martin_vulcan,
                R.drawable.aston_martin_dbs_superleggera
            )
        }
    }

    fun getDescription(name: String): String {
        return when (name) {
            "Ferrari" -> "Pojazdy cywilne Ferrari, produkowane od 1947 roku, znane ze swego wyszukanego stylu z domu Pininfarina, były i są symbolem luksusu. Ferrari korzystał również z designu innych projektantów, a mianowicie byli to Scaglietti, Bertone i Vignale.\n" +
                    "Stosunkowo niewielkie silniki 8- i 12-cylindrowe w układzie V, odznaczające się wysokimi osiągami oraz specyficznym brzmieniem i piękny wygląd czynią wozy Ferrari obiektem pożądania.\n" +
                    "Od wielu lat głównymi konkurentami marki Ferrari są produkty Porsche i Lamborghini."
            "Lamborghini" -> "Mówi się, że powstanie samochodów Lamborghini wynikło z dyskusji pomiędzy miłośnikiem wozów sportowych Ferruccim Lamborghinim (1916–1993) a Enzo Ferrarim. Lamborghini, który wówczas z powodzeniem produkował wyłącznie traktory, był niezadowolony ze " +
                    "swego samochodu Ferrari i zaproponował Enzo Ferrariemu wprowadzenie zmian konstrukcyjnych. Ten oburzony uwagami „jakiegoś traktorzysty” zakwestionował kompetencje Lamborghiniego. Wobec tego Lamborghini postanowił udowodnić mu kto jest lepszy i już po roku zademonstrował " +
                    "swój legendarny 12-cylindrowy model Lamborghini 350 GTV, wyraźnie przewyższający samochody marki Ferrari."
            else -> "Przedsiębiorstwo Aston Martin zostało założone w 1914 przez Lionela Martina i Roberta Bamforda, którzy już wcześniej zajmowali się sprzedażą samochodów Singer. Martin ponadto zajmował się samochodowymi wyścigami górskimi na wzgórzu Aston Hill w okolicy miejscowości Aston Clinton. Martin i Bamford postanowili produkować własne samochody wyścigowe, lepsze jakościowo od Singerów. Produkcję umieścili w warsztacie w Londynie, nazwę przedsiębiorstwa utworzono od Aston Hill i nazwiska Martina. Pierwszy samochód wyprodukowali w marcu 1915, lecz później nastąpiła przerwa spowodowana I wojną światową."
        }
    }
}