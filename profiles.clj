{:shared {:plugins [[cider/cider-nrepl "0.11.0-SNAPSHOT"]
                    [jonase/eastwood "0.2.3"]
                    [lein-ancient "0.6.10"]
                    [org.clojure/tools.nrepl "0.2.12"]
                    [com.jakemccrary/lein-test-refresh "0.11.0"]]
          :global-vars {*print-length* 100}
          :figwheel {:open-file-command "figwheel-file-opener"}
          :test-refresh {:growl true}}
 :vinyasa {:dependencies [[im.chit/vinyasa "0.2.2" :exclusions [org.codehaus.plexus/plexus-utils]]
                          [im.chit/iroh "0.1.11"]
                          [org.clojure/tools.namespace "0.2.11"]
                          [aprint "0.1.3"]
                          [spyscope "0.1.5" :exclusions [clj-time]]]
           :injections [(require '[vinyasa.inject :as inject]
                                 'spyscope.core)
                        (inject/in [vinyasa.inject :refer [inject [in inject-in]]]
                                   [vinyasa.pull :all]
                                   [cemerick.pomegranate add-classpath get-classpath resources]
                                   [clojure.tools.namespace.repl refresh]
                                   clojure.core
                                   [iroh.core .> .? .* .% .%>]
                                   clojure.core >
                                   [clojure.pprint pprint]
                                   [clojure.java.shell sh]
                                   [clojure.repl doc source pst])]}
 :droid {:plugins [[lein-droid "0.4.0-alpha4"]]}
 :moar-opts {:jvm-opts ["-XX:+UnlockDiagnosticVMOptions" "-XX:+DebugNonSafepoints" "-XX:+UnlockCommercialFeatures" "-XX:+FlightRecorder"]}
 :yagni {:plugins [[venantius/yagni "0.1.2"]]}
 :refactor {:plugins [[refactor-nrepl "2.0.0"]]}
 :user [:shared :vinyasa :moar-opts :refactor]}

