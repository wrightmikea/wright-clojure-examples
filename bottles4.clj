(defn sing
  ([] (sing 99))
  ([n]
     (let [r1 (range n 1 -1)
	   otw " on the wall.\n\t"
	   bob #(str %1 " bottle" (if (= 1 %1) "" "s") " of beer" %2)
	   tod #(str "Take " %1 " down, pass it around;\n\t" (bob %2 otw) "\n")]
       (apply str
	      (concat
	       (doall
		(interleave
		 (map #(bob % otw) r1)
		 (map #(bob % ".\n") r1)
		 (map #(tod "one" (dec %)) r1)))
	       (list (bob 1 otw)(bob 1 ".\n")(tod "it" "No more")))))))


