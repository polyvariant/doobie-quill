# doobie-quill

The integration for [Doobie](https://tpolecat.github.io/doobie) and [Quill](https://getquill.io). Originally implemented in Doobie.

## Usage

```scala
libraryDependencies ++= Seq(
  "org.polyvariant" %% "doobie-quill" % version
)
```

For now docs are [here](docs/src/main/mdoc/docs/main.md), we'll have a site in the upcoming future.

## Migrating from original integration

1. Replace the dependency
2. Replace imports: `doobie.quill` -> `org.polyvariant.doobiequill`
3. Test your code :)
