(ns clojure-todo-app.system
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http :as http]
            [clojure-todo-app.components.web.pedestal :as pedestal]
            [clojure-todo-app.components.web.routes :as routes]
            [clojure-todo-app.components.db.postgres :as postgres]))


(defn- build-service-map [env]
  {:env env
   ::http/routes routes/routes
   ::http/type :jetty
   ::http/host (or (System/getenv "WEB_HOST") "localhost")
   ::http/port 8080
   ::http/resource-path "/public"
   ::http/join? false})


(defn system [env]
  (component/system-map
    :service-map
    (build-service-map env)

    :db-config
    {:db "clojure"
                :user "clojure"
                :password "clojure"
                :host (or (System/getenv "WEB_HOST") "localhost")}
    
    :db
    (component/using
      (postgres/new-database)
      [:db-config])
    
    :web
    (component/using
      (pedestal/new-pedestal)
      [:db :service-map])))


(defn -main [& args]
  (component/start (system {})))
