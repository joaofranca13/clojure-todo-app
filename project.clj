(defproject clojure-todo-app "0.1.0-SNAPSHOT"
  :description "Creating a todo app with Clojure"
  :url "https://github.com/joaofranca13/clojure-todo-app"
  :license {:name "MIT"
            :url "https://opensouArce.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 
                 ;; Lifecycle
                 [com.stuartsierra/component "1.0.0"]
                 
                 ;; Http abstraction
                 [ring/ring-core "1.8.1"]
                 
                 ;; Clojure HTML
                 [hiccup "1.0.5"]
                 
                 ;; Web Server
                 [io.pedestal/pedestal.service "0.5.7"]
                 [io.pedestal/pedestal.jetty "0.5.7"]
                 
                 ;; database
                 [org.clojure/java.jdbc "0.7.11"]
                 [org.postgresql/postgresql "42.2.12"]
                 [org.xerial/sqlite-jdbc "3.31.1"]
                 [korma "0.4.3"]]

  :plugins [[cider/cider-nrepl "0.24.0"]]
  :main ^{skip-aot false} clojure-todo-app.system
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
