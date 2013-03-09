(ns my-stuff.text)
(use '[clojure.string :only (split split-lines)])

(def styles {
:优雅 "4fd18aafe4b073c16e68ca68"
:甜美风 "4fd195a8e4b0df0e4690b1d9"
:休闲舒适 "4fd196e3e4b0df0e4690b1db"
:前卫摩登 "4fd1983ce4b0df0e4690b1dc"
:波希米亚风格 "4fd19960e4b0df0e4690b1dd"
:森林系 "4fd1996de4b0df0e4690b1de"
:民族风 "4fd1997be4b0df0e4690b1df"
:经典简约 "4fd19986e4b0df0e4690b1e0"
:中性 "4fd19992e4b0df0e4690b1e1"
:不鲜明风格 "4fd199b2e4b0df0e4690b1e3"
:仙儿 "4fd89e23e4b073b215e62582"
:极简风 "4fd89e6be4b073b215e62584"
:文艺范儿 "4fd89e3de4b073b215e62583"
:简单大气有范儿 "4fd89ea6e4b073b215e62585"
:学院风 "4fda9a32e4b073b215e625b6"
:度假风 "4fda9a44e4b073b215e625b7"
:淑女名媛 "4fda9a51e4b073b215e625b8"
:朋克嘻哈风 "4fdad7fde4b073b215e62618"
:军旅风 "4fdad806e4b073b215e6261a"
:田园风 "4fdd30b7e4b073b215e626d4"
:OL通勤 "4fd199a8e4b0df0e4690b1e2"
:英伦风 "4fc74258e4b08baf6cbc446f"
:街头风 "4fc74247e4b08baf6cbc446e"
:复古风 "4fdd98c4e4b04e4b0129efe8"
:欧美风 "4fdd9979e4b04e4b0129efea"
:日韩风 "4fdd9a13e4b04e4b0129efee"
:性感 "4fe91f3fe4b0bee1234505a2"
             })

(defn -main
  "main"
  [& args]
  (let [txt (split-lines (slurp "/home/zhaodj/文档/work/时尚大号.txt"))] 
    (loop [line txt] 
      (let [item (split line #"\s+")] 
        (loop [i item] 
          (println i)))))
  (println (keys styles)))
