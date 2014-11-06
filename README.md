# OpenData SMN 

[![Build Status](https://travis-ci.org/marcelstoer/open-data-smn.svg?branch=master)](https://travis-ci.org/marcelstoer/open-data-smn)
[![Coverage Status](https://coveralls.io/repos/marcelstoer/open-data-smn/badge.png?branch=master)](https://coveralls.io/r/marcelstoer/open-data-smn?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.frightanic/open-data-smn/)

OpenData SMN is a simple REST API for [SwissMetNet data](http://www.meteoschweiz.admin.ch/web/en/climate/observation_systems/surface/swissmetnet.html). It's developed in the open supporting the [OpenData.ch](http://opendata.ch/) initiative. Free OpenData hosting is provided by [Netcetera](http://netcetera.com) at [data.netcetera.com/smn](http://data.netcetera.com/smn/).

The actual data for 10min intervals is provided by [opendata.admin.ch](http://www.opendata.admin.ch/en/dataset/messdatensmn), the Swiss open government data _pilot_ portal. Due to the "maybe not here to stay"-nature of that portal no mid-/long-term promise can be made as for the sustainability of OpenData SMN. You probably don't want to base a mission-critical application on it right now.

Rather than manually maintaining an (often outdated) API documentation here OpenData SMN relies on [Swagger](https://helloreverb.com/developers/swagger). It provides an automatically generated, 100% up-to-date and - best of all - executable [API documentation](http://data.netcetera.com/smn/swagger). Each REST operation can be executed directly from the Swagger UI.

## Contributing
Please have a look at the [contributing guidelines](CONTRIBUTING.md) if you want to improve this project.

## License
[MIT](http://opensource.org/licenses/MIT) © Marcel Stör
