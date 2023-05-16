;; 1)
;; Definir la función tercer-angulo que reciba los valores de dos de los ángulos 
;; interiores de un triángulo y devuelva el valor del restante.
(defn tercer-angulo [a b] (- 180 (+ a b)))

;; 2)
;; Definir la función segundos que reciba los cuatro valores (días, horas, minutos y 
;; segundos) del tiempo que dura un evento y devuelva el valor de ese tiempo expresado 
;; solamente en segundos.
(defn segundos [dias horas min segs] (+ segs (* min 60) (* horas 3600) (* dias 86400)))

;; 3)
;; Definir la función sig-mul-10 que reciba un número entero y devuelva el primer 
;; múltiplo de 10 que lo supere.
(defn sig-mul-10 [a] (* (inc (quot (- a (rem a 10)) 10)) 10))

;; 4)
;; Definir las funciones red, green, blue y alpha que reciban el valor numérico de un 
;; color de 32 bits y devuelvan, respectivamente, los valores de las componentes rojo, 
;; verde, azul y alfa (RGBA: red, green, blue, alpha) del mismo.
(defn red [color] (quot color 0x10000))
(defn blue [color] (rem (quot color 0x100) 0x100))
(defn green [color] (rem color 0x100))

;; 5)
;; Definir la función capicua? que reciba un número entero no negativo de hasta 5 
;; dígitos y devuelva true si el número es capicúa; si no, false.
;; 15251 => true
;; 15259 => false
;; 1225 => false
;; 454 => true
(defn capicua [a] (list a))

;; 7)
;; Definir la función invertir que reciba un número entero no negativo y lo devuelva 
;; espejado.
(defn invertir [a] (symbol (reduce str (reverse (apply list (str a))))))
(defn borrarBarras [a] (symbol (str a)))

;; 8)
;; Definir la función nth-fibo que reciba un número entero no negativo y devuelva el 
;; correspondiente término de la sucesión de Fibonacci.
(defn nth-fibo [a] (if (> a 0) () 'No-es-un-numero-positivo))

;; 9)
;; Definir la función cant-dig que reciba un número entero y devuelva la cantidad de 
;; dígitos que este tiene.
(defn cant-dig [a] (count (apply list (str a))))

;; 10)
;; Definir la función pot? que reciba dos números naturales y devuelva true si el 
;; primero es potencia del segundo; si no, false.
(defn pot? [a b] (= a (* b b)))

;; 11)
;; Definir la función digs que reciba un número y devuelva una lista con sus dígitos.
(defn digs [a] (map borrarBarras (apply list (str a))))

;; 12
;; Definir la función repartir que, llamada sin argumentos, devuelva la cadena
;; "Uno para vos, uno para mí". De lo contrario, se devolverá una lista, en la que 
;; habrá una cadena "Uno para X, uno para mí" por cada argumento X.
(defn repartir [& a] (if (nil? a) "Uno para vos, uno para mi" (map (fn [x] (apply str (concat "Uno para " x ", uno para mi"))) a )))

;; 13
;; Definir una función para producir una lista con los elementos en las posiciones pares 
;; de dos listas dadas
(defn listaConElementosPares [seq1 seq2] (list ))

