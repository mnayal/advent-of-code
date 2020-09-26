(ns advent-of-code.day-1-test
  (:require  [clojure.test :refer :all]
             [clojure.java.io :as io]
             [clojure.string :as string]))

(defn- getInteger [x]
  )

(defn calculate-fuel [x]
  (- (int (/ x 3))
     2))

(defn calculate-using-recur [total mass]
  (let [new-fuel (calculate-fuel mass)]
    (if (> new-fuel 0)
      (recur (+ total new-fuel) new-fuel)
      total)))

(defn normal-recur [input-fuel]
  (let [new-fuel (calculate-fuel input-fuel)]
   (if (> new-fuel 0)
     (+ input-fuel (normal-recur new-fuel))
     input-fuel)))

(defn total []
  (let [values (string/split (slurp (io/resource "input.txt")) #"\n")
        total-1 (reduce (fn [t f]
                          (+ t (calculate-using-recur 0 (Integer/parseInt f))))
                        0 values)]
    total-1))

(total)

(deftest problem1
  (is (= 2
         (solution 12))))
