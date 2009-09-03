(defn bottles [n]
  (str n " bottle" (if (= 1 n) "" "s")))
(declare even)
(defn odd [n]
  (if (pos? n)
    (do
      (println (bottles n) "of beer on the wall," (bottles n) "of beer.")
      #(even (dec n)))
    nil))
(defn even [n]
    (do
      (println "Take one down and pass it around," (bottles n) "of beer on the wall.\n")
      (if (pos? n)
	#(odd n)
	nil)))
(defn sing
  ([] (sing 99)) ; default
  ([n] (trampoline #(odd n))))