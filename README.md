# OpenData SMN

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/marcelstoer/open-data-smn/blob/master/LICENSE)

OpenData SMN is a simple REST API for [SwissMetNet data](http://www.meteoschweiz.admin.ch/home/mess-und-prognosesysteme/bodenstationen/automatisches-messnetz.html).
It's developed in the open supporting the [OpenData.ch](http://opendata.ch/) initiative.

The actual data for 10min intervals is provided by [opendata.swiss](https://opendata.swiss/de/dataset/automatische-wetterstationen-aktuelle-messwerte), the Swiss open government data portal.

v1.1+ supports [GeoJSON](http://en.wikipedia.org/wiki/GeoJSON) through `Accept` header content negotiation.

## Getting started

- run `mvn quarkus:dev` in the project root folder
- navigate to http://localhost:8080

## Docker
There's a Docker image at [https://hub.docker.com/r/marcelstoer/open-data-smn](https://hub.docker.com/r/marcelstoer/open-data-smn) for the following architectures:

- linux/amd64,
- linux/arm64

## Contributing
Please have a look at the [contributing guidelines](CONTRIBUTING.md) if you want to improve this project.

## License
[MIT](http://opensource.org/licenses/MIT) © Marcel Stör
