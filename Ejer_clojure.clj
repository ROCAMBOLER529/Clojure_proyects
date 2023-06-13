
(defn pertenece [seq a] (aany? (fn [x] (= x a)) seq))
(defn planchar [lis] (if (empty? lis) 
                       '() ;; si la lista está vacía, devuelve vacío
                       (if (seq? (first lis)) ;; si el primer elemento es una lista
                         (concat (planchar (first lis)) (planchar (rest lis))) ;; concatenar el primer elemento de la lista PLANCHADA con la original MENOS EL PRIMER ELEMENTO
                         (cons (first lis) (planchar (rest lis))) ;; sino, concatenar el primer elemento con la lista original MENOS EL PRIMER ELEMENTO
                         )
                       )
  )

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
(defn red [color] (quot color 0x1000000))
(defn blue [color] (rem (quot color 0x10000) 0x10000))
(defn green [color] (rem color 0x100))

;; 5)
;; Definir la función capicua? que reciba un número entero no negativo de hasta 5 
;; dígitos y devuelva true si el número es capicúa; si no, false.
;; 15251 => true
;; 15259 => false
;; 1225 => false
;; 454 => true
(defn capicua [a] (partition a))

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
(defn listaConElementosPares [seq1 seq2] (concat (elemPares seq1) (elemPares seq2)))
(defn elemPares [seq] (map first (partition 2 seq)))
;; CORREGIR PARA QUE EL ULTIMO VALOR DE UNA SEQUENCIA IMPAR SEA AGREGADO

;; 14
;; La transcripción es el proceso en el que la secuencia de ADN de un gen se copia 
;; (Tanscribe) para hacer una molécula de ARN. La cadena de ARN transcrita se forma 
;; reemplazando cada nucleótido del ADN por su complemento de ARN: G → C, C → G, 
;; T → A y, por último, A → U. Definir la función adn2arn que reciba una cadena de 
;; ADN y la devuelva transcrita en ARN
(defn adn2arn [adn] (map gcta adn))
(defn gcta [x] (cond 
    (= x 'G) 'C
    (= x 'C) 'G
    (= x 'T) 'A
    (= x 'A) 'U
))

;; 15
;; Definir una función para eliminar las ocurrencias de un dato escalar en una lista (a 
;; todo nivel).
(defn aany? [fun seq] (false? (not-any? fun seq)))
(defn eliminarOcurrencias [seq a] (if (aany? seq? seq) (remove (fn [x] (= x a)) (map (fn [x] (if (seq? x) (eliminarOcurrencias x a) x)) seq)) (remove (fn [x] (= x a)) seq)))

;; 16
;; Definir una función para obtener el último símbolo de una lista (a todo nivel)
(defn ultimoSimbolo [lis] (last (filter symbol? (flatten lis))))

;; 17
;; Definir una función para obtener el elemento central de una lista
(defn medio [lis] (first (second (partition (quot (count lis) 2) lis))))

;; 18
;; Definir una función para eliminar los elementos repetidos de una lista simple
(defn elemRepetidos [lis] (if (empty? lis) lis (cons (first lis) (elemRepetidos (filter (fn [x] (not= (first lis) x)) (rest lis))))))

;; 19
;; Definir una función para ordenar una lista de listas por longitud creciente.
(defn ordenarListas [lis] (sort (fn [x y] (- (count y) (count x))) lis))
                                 
;; 20 
;; Un ISBN-10 es válido si sus 10 dígitos x1, x2, x3, ... x10 cumplen lo siguiente:
;; (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
;; Un ISBN-10 está dividido en cuatro partes: el código de país o lengua de origen (de 1 
;; a 5 dígitos), el editor, el número del artículo y un dígito de control. Opcionalmente, 
;; estas cuatro partes pueden estar separadas mediante espacios en blanco o guiones. 
;; El dígito de control puede valer X que representa el valor 10. Por ejemplo,
;; 3-598-21507-X es un ISBN-10 válido. Escribir la función isbn-10? que devuelve 
;; true si la cadena recibida es un ISBN-10 válido; si no, false.
(defn convertir-a-num [lis] (map (fn [x] (- (long x) 48)) lis))
(defn isbn-10-to-num [cad] (if (= (last cad) \X) (concat (convertir-a-num (filter (fn [x] (and (not= x \-) (not= x \X))) (butlast (apply list cad)))) '(10)) (convertir-a-num (filter (fn [x] (not= x \-)) (apply list cad)))))
(defn isbn-10? [isbn] (= (rem (reduce (fn [x y] (+ x y)) (map (fn [x y] (* x y)) (isbn-10-to-num isbn) '(10 9 8 7 6 5 4 3 2 1))) 11) 0))

;; 21 
;; Definir una función para obtener la matriz triangular superior (incluyendo la diagonal
;; principal) de una matriz cuadrada que está representada como una lista de listas.
(defn matrizTrangularSuperior [mat] (map (fn [x] (map (fn [y] (if (> (.indexOf mat x) (.indexOf x y)) 0 y)) x)) mat))

;; 22
;; Definir una función para obtener la diagonal principal de una matriz cuadrada que
;; está representada como una lista de listas.
(defn diagonalPrincipal [mat] (map (fn [x] (first (drop (.indexOf mat x) x))) mat))

;; 23
;; Definir una función para transponer una lista de listas.
(defn trans [lis] (apply map list lis))

;; 24
;; Definir una función que cuente las apariciones de cada nucleótido en una cadena de
;; ADN
(defn strNucleotido [adn] (map borrarBarras (apply list adn)))
(defn countNucelotidos [adn] (list (count (filter (fn [x] (= x 'A)) (strNucleotido adn))) (count (filter (fn [x] (= x 'C)) (strNucleotido adn))) (count (filter (fn [x] (= x 'G)) (strNucleotido adn))) (count (filter (fn [x] (= x 'T)) (strNucleotido adn)))))

;; 25
;; Definir una función que cuente las apariciones de cada palabra en una frase.
(defn countPalabras [cad] ( (apply list cad)))

;; Parcial
(defn esPerfecto? [n] (= (reduce (fn [x y] (+ x y)) (filter (fn [x] (= (rem n x) 0)) (first (partition (inc (quot (count (range 1 n)) 2)) (range 1 n))))) n))

