(ns clj-bwt.core-test
  (:require [clojure.test :refer :all]
            [clj-bwt.core :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.string :as str]))

(deftest rotations-test
  (is (= (rotations [1 2 3]) '((1 2 3) (2 3 1) (3 1 2)))))

(deftest bwt-test
  (is (= (bwt "The rain in Spain stays mainly in the plain" \$)
         "nnyseennn $rplmthhtT aa aapn iiiiiiS  y s la")))

(deftest reverse-bwt-test
  (is (= (reverse-bwt (bwt "The rain in Spain stays mainly in the plain" \$) \$)
         "The rain in Spain stays mainly in the plain")))

(defspec test-bwt-and-reverse
  100
  (prop/for-all
   [s (gen/such-that #(not (str/includes? % "$")) gen/string)]
   (= (reverse-bwt (bwt s \$) \$) s)))
