# doobie-quill

The integration for [Doobie](https://tpolecat.github.io/doobie) and [Quill](https://getquill.io). Originally implemented in Doobie.

## Usage

```scala
libraryDependencies ++= Seq(
  "org.polyvariant" %% "doobie-quill" % version
)
```

For now docs are [here](docs/src/main/mdoc/docs/main.md), we'll have a site in the upcoming future.

## Version compatibility

| This library | Doobie    | Quill |
| ------------ | --------- | ----- |
| 0.0.1        | 1.0.0-RC1 | 3.11.0 |

## Migrating from original integration

1. Replace the dependency
2. Replace imports: `doobie.quill` -> `org.polyvariant.doobiequill`
3. Test your code :)

## Community

This project supports the [Scala code of conduct](https://www.scala-lang.org/conduct/) and wants communication on all its channels (GitHub etc.) to be inclusive environments.

If you have any concerns about someone's behavior on these channels, contact [Jakub Kozłowski](mailto:kubukoz@gmail.com).
