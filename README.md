# OpenData SMN 

[![Build Status](https://travis-ci.org/marcelstoer/open-data-smn.svg?branch=master)](https://travis-ci.org/marcelstoer/open-data-smn)
[![Coverage Status](https://coveralls.io/repos/marcelstoer/open-data-smn/badge.svg?branch=master)](https://coveralls.io/r/marcelstoer/open-data-smn?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.frightanic%3Aopen-data-smn&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.frightanic%3Aopen-data-smn)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/marcelstoer/open-data-smn/blob/master/LICENSE)

OpenData SMN is a simple REST API for [SwissMetNet data](http://www.meteoschweiz.admin.ch/home/mess-und-prognosesysteme/bodenstationen/automatisches-messnetz.html). It's developed in the open supporting the [OpenData.ch](http://opendata.ch/) initiative. Free OpenData hosting is provided by [Netcetera](http://netcetera.com) at [data.netcetera.com/smn](http://data.netcetera.com/smn/).

The actual data for 10min intervals is provided by [opendata.swiss](https://opendata.swiss/de/dataset/automatische-wetterstationen-aktuelle-messwerte), the Swiss open government data portal.

Rather than manually maintaining an (often outdated) API documentation here OpenData SMN relies on [Swagger](https://swagger.io/). It provides an automatically generated, 100% up-to-date and - best of all - executable [API documentation](http://data.netcetera.com/smn/swagger). Each REST operation can be executed directly from the Swagger UI.

v1.1 supports [GeoJSON](http://en.wikipedia.org/wiki/GeoJSON) through `Accept` header content negotiation.

## Hosting
You can very easily host this tiny app yourself with Docker or in the cloud.

### Docker
There's a Docker image at [https://hub.docker.com/r/marcelstoer/open-data-smn](https://hub.docker.com/r/marcelstoer/open-data-smn) for the following architectures:

- linux/amd64, 
- linux/arm/v7
- linux/arm64

The ARM images allow you to run this on Raspberry Pi.

### Cloud
Every cloud is different but here's an example. Running this on [Heroku](https://dashboard.heroku.com) (free!) is super easy.

- On GitHub: fork this repo
- On Heroku: apen an account, create a new app (ignore the pipeline settings), connect your GitHub fork for the deployment, tell Heroku to deploy the `heroku` branch. Done! 

## Contributing
Please have a look at the [contributing guidelines](CONTRIBUTING.md) if you want to improve this project.

## License
[MIT](http://opensource.org/licenses/MIT) © Marcel Stör
