# fxkit-plugin

A Leiningen hook to compile JavaFX 8 in clojure.

## Usage

### Use this for user-level plugins:

Put `[fxkit-plugin "0.1.0"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
fxkit-plugin 0.1.0`.

### Use this for project-level plugins:

Put `[fxkit-plugin "0.1.0"]` into the `:plugins` vector of your project.clj.

### usage:

    $ lein compile

## License

Copyright © 2013 misty

Distributed under the Eclipse Public License, the same as Clojure.
