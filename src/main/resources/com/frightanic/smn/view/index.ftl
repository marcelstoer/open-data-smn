<#-- @ftlvariable name="" type="com.frightanic.smn.view.IndexView" -->
<!-- template from http://www.html5webtemplates.co.uk/templates.html - black & white -->
<!DOCTYPE HTML>
<html>

<head>
  <title>${title}</title>
  <meta name="description" content="OpenData SMN is a simple API for SwissMetNet data under the OpenData.ch umbrella"
          />
  <meta name="keywords" content="OpenData, SwissMetNet, Swiss Met Net, API, JSON"/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  <style>
    html {
      height: 100%;
    }

    * {
      margin: 0;
      padding: 0;
    }

    body {
      font: normal 1em 'trebuchet ms', arial, sans-serif;
      background: #FFF repeat;
      color: #000;
    }

    p {
      padding: 0 0 20px 0;
      line-height: 1.7em;
    }

    h1, h2, h3, h4, h5, h6 {
      font: normal 175% 'century gothic', arial, sans-serif;
      color: #000;
      margin: 0 0 15px 0;
      padding: 15px 0 5px 0;
    }

    h2 {
      font: normal 175% 'century gothic', arial, sans-serif;
    }

    h4, h5, h6 {
      margin: 0;
      padding: 0 0 5px 0;
      font: normal 120% arial, sans-serif;
    }

    h5, h6 {
      font: italic 95% arial, sans-serif;
      padding: 0 0 15px 0;
    }

    a, a:hover {
      outline: none;
      text-decoration: underline;
      color: #000;
    }

    a:hover {
      text-decoration: none;
    }

    blockquote {
      margin: 20px 0;
      padding: 10px 20px 0 20px;
      border: 1px solid #E5E5DB;
      background: #FFF;
    }

    ul {
      margin: 2px 0 22px 17px;
    }

    ul li {
      list-style-type: circle;
      margin: 0 0 6px 0;
      padding: 0 0 4px 5px;
    }

    ol {
      margin: 8px 0 22px 20px;
    }

    ol li {
      margin: 0 0 11px 0;
    }

    #main, #logo, #site_content, #footer {
      margin-left: auto;
      margin-right: auto;
    }

    #header {
      background: transparent;
      height: 148px;
    }

    #logo {
      width: 898px;
      position: relative;
      height: 148px;
    }

    #logo #logo_text {
      position: absolute;
      top: 20px;
      left: 0;
    }

    #logo h1, #logo h2 {
      font: normal 300% 'century gothic', arial, sans-serif;
      border-bottom: 0;
      text-transform: none;
      margin: 0;
    }

    #logo_text h1, #logo_text h1 a, #logo_text h1 a:hover {
      padding: 22px 0 0 0;
      letter-spacing: -1px;
      text-decoration: none;
    }

    #logo_text h2 {
      font-size: 100%;
      padding: 4px 0 0 0;
    }

    #site_content {
      width: 898px;
      overflow: hidden;
      margin: 0 auto 0 auto;
      padding: 0 0 20px 0;
    }

    #content {
      text-align: left;
      float: left;
      padding: 0;
    }

    #content ul {
      margin: 2px 0 22px 0;
    }

    #content ul li {
      list-style-type: none;
      margin: 0 0 6px 0;
      padding: 0 0 4px 25px;
      line-height: 1.5em;
    }

    #footer {
      width: 898px;
      font: normal 100% 'lucida sans unicode', arial, sans-serif;
      height: 33px;
      padding: 24px 0 5px 0;
      text-align: center;
      background: transparent;
      text-transform: uppercase;
      letter-spacing: 0.1em;
    }

    #footer a {
      text-decoration: none;
    }

    #footer a:hover {
      text-decoration: underline;
    }

    table {
      margin: 10px 0 30px 0;
    }

    table tr th, table tr td {
      background: #3B3B3B;
      padding: 7px 4px;
      text-align: left;
    }

    table tr td {
      background: #F0EFE2;
      color: #47433F;
      border-top: 1px solid #FFF;
    }
  </style>
</head>

<body>
<div id="main">
  <div id="header">
    <div id="logo">
      <div id="logo_text">
        <h1><a href="./">OpenData SMN</a></h1>

        <h2>A simple API for SwissMetNet data</h2>
      </div>
    </div>
  </div>
  <div id="site_content">
    <div id="content">
      <p>
        OpenData SMN is a simple REST API for <a
              href="http://www.meteoschweiz.admin.ch/home/mess-und-prognosesysteme/bodenstationen/automatisches-messnetz.html">SwissMetNet
        data</a>.
        It's developed in the open supporting the <a href="http://opendata.ch/">OpenData.ch</a> initiative.
        Free OpenData hosting is provided by <a href="http://netcetera.com">Netcetera</a>.
      </p>

      <p>The actual data for 10min intervals is provided by <a
              href="http://www.opendata.admin.ch/en/dataset/messdatensmn">opendata.admin.ch</a>,
        the Swiss open government data <em>pilot</em> portal. Due
        to the "maybe not here to stay"-nature of that portal no mid-/long-term promise can be made as for the
        sustainability of OpenData SMN. You probably don't want to base a mission-critical application on it right now.
      </p>

      <p>
        Rather than manually maintaining an (often outdated) API documentation here OpenData SMN relies on <a
              href="https://helloreverb.com/developers/swagger">Swagger</a>. At <a href="./swagger">./swagger</a> you
        find an automatically generated, 100% up-to-date and - best of all - executable API documentation. Each
        REST operation can be executed directly from the Swagger UI.
      </p>
    </div>
  </div>
  <div id="footer">
    Copyright &copy; <a href="http://frightanic.com">Marcel Stör</a><!-- | <a href="https://github
      .com/marcelstoer/open-data-smn">fork on GitHub</a>-->
  </div>
</div>
<a href="https://github.com/marcelstoer/open-data-smn"><img style="position: absolute; top: 0; right: 0; border: 0;"
                                                            src="https://camo.githubusercontent.com/a6677b08c955af8400f44c6298f40e7d19cc5b2d/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677261795f3664366436642e706e67"
                                                            alt="Fork me on GitHub"
                                                            data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png"></a>
</body>
</html>