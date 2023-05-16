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
(defn invertir [a] (str a))
