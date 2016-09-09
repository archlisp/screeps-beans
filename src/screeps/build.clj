(ns screeps.build
  (:require [cljs.build.api :as b]
            [clj-http.client :as client]))

(defn deploy-build
  []
  (let [user (System/getenv "SCREEPS_USERNAME")
        passwd (System/getenv "SCREEPS_PASSWORD")
        branch (or (System/getenv "SCREEPS_BRANCH") "test")]
    (if (and user passwd)
      (do
        (println "deploying code...")
        (let [request (client/post "https://screeps.com/api/user/code"
                                   {:basic-auth [user passwd]
                                    :content-type :json
                                    :accept :json
                                    :form-params {:branch branch
                                                  :modules {:main (slurp "release/main.js")}}
                                    :as :json})]
          (if-let [error (get-in request [:body :error])]
            (println "ERROR deploying to screeps.com: " error)
            (println "done!"))))
      (println "export SCREEPS_USERNAME and SCREEPS_PASSWORD (optionally SCREEPS_BRANCH) to autodeploy code."))))

(defn watch
  []
  (println "Watching release ...")
  (b/watch "src"
           {:output-to "release/main.js"
            :output-dir "release"
            :optimizations :advanced
            :watch-fn deploy-build
            :verbose true}))
