(ns advent-of-code.day-2-test
  (:require  [clojure.test :as t]
             [clojure.java.io :as io]
             [clojure.string :as string]))

(defn calculate [input position operator]
  (let [[op a1 a2 out] input
        first (nth input (nth input (+ position 1)))
        secnd (nth input (nth input (+ position 2)))]

    (assoc input (nth input (+ position 3)) (operator first secnd))))

(let [[a b c & others :as x] [1 2 3 4 5]]
  x)
(take 4
      (drop position input))

(defn int-output [input position]
  (let [action (nth input position)
        operations {1 +
                    2 *}
        (calculate input position (operations action))
        new-vector (condp = action
             
                     1 
                     2 (calculate input position *)
                     99 input)]
    (if (= action 99)
      new-vector
      (recur new-vector
             (+ position 4)))))
(defn replace [input]
  (assoc input 1 12 2 2))

(defn input []
  (let [file-input (slurp (io/resource
                           "input2.txt"))]
    (string/split (string/replace
                   file-input
                   "\n" "")
                  #",")))

(defn get-input-vec []
  (mapv #(Integer/parseInt %)
        (input)))

(first (int-output (replace (get-input-vec)) 0))
