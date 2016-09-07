(defproject cljs-screeps "0.1.0-SNAPSHOT"
  :description "screeps clojurescript"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [cheshire "5.5.0"]
                 [clj-http "2.0.0"]
                 [org.clojure/data.codec "0.1.0"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]]
  :npm {:dependencies [[source-map-support "0.3.2"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target")
