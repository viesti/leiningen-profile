{:shared {:plugins [[cider/cider-nrepl "0.8.0-SNAPSHOT"]]
          :repl-options {:init (set! *print-length* 42)}}
 :vinyasa {:dependencies [[im.chit/vinyasa "0.2.2"]
                          [im.chit/iroh "0.1.11"]]
           :injections [(require '[vinyasa.inject :as inject])
                        (inject/in
                         [vinyasa.inject :refer [inject [in inject-in]]]
                         [vinyasa.pull :all]
                         [cemerick.pomegranate add-classpath get-classpath resources]
                         clojure.core
                         [iroh.core .> .? .* .% .%>]
                         clojure.core >
                         [clojure.pprint pprint]
                         [clojure.java.shell sh])]}
 :user [:shared :vinyasa]}
