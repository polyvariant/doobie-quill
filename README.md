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

| This library | Doobie    | Quill  |
| ------------ | --------- | ------ |
| 0.0.4        | 1.0.0-RC1 | 3.14.x |
| 0.0.3        | 1.0.0-RC1 | 3.12.x |
| 0.0.2        | 1.0.0-RC1 | 3.11.x |
| 0.0.1        | 1.0.0-RC1 | 3.8.x  |

## Migrating from original integration

1. Replace the dependency
2. Replace imports: `doobie.quill` -> `org.polyvariant.doobiequill`
3. Test your code :)

## Community

This project supports the [Scala code of conduct](https://www.scala-lang.org/conduct/) and wants communication on all its channels (GitHub etc.) to be inclusive environments.

If you have any concerns about someone's behavior on these channels, contact [Jakub Kozłowski](mailto:kubukoz@gmail.com).
