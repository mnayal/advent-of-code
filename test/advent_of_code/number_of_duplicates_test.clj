(ns advent-of-code.number-of-duplicates-test
  (:require  [clojure.test :as t]
             [clojure.java.io :as io]
             [clojure.string :as string]))


(defn read-file []
  (string/split (slurp (io/resource "Extra 19800 Codes.csv")) #"\r\n"))


(spit "output19800codes_temp.csv"
      (string/join "\n"
                   (map #(string/join "," %)
                        (sort-by second > (filter #(> (second %) 1)
                                                  (frequencies (read-file)))) )))


(reduce #(+ %1 (second %2)) 0 (filter #(> (second %) 1)
                                      (frequencies (read-file))))

(comment 2508)
(comment 1207)
(comment 18199)


(count (filter #(> (second %) 1)
               (frequencies (read-file))))



(count (read-file))
