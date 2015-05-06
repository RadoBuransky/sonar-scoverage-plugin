#Sonar Scoverage Plugin 1.1.1#

[![Build Status](https://travis-ci.org/RadoBuransky/sonar-scoverage-plugin.png)](https://travis-ci.org/RadoBuransky/sonar-scoverage-plugin)

Plugin for [SonarQube] that imports statement coverage generated by [Scoverage] for Scala projects.

Scoverage measures how many statements of a given Scala program have been covered by automated tests. This
new metric is much better for Scala than traditional line coverage and branch coverage because typically:

 1. There are many statements on a single line
 2. `if` statements are used rarely

This plugin reads XML report generated by Scoverage and populates several metrics in Sonar:

 1. Total number of statements
 2. Number of statements covered by tests
 3. Statement coverage rate (%)

Projects with sub-projects are supported as well. Overall statement coverage is (sum of number of covered statements
for all sub-projects) / (total number of statements for all sub-projects). In other words, it's more intelligent than
just plain average of coverage rates for sub-projects.

## Requirements ##

- [SonarQube] 4.5.4
- [sonar-scala] 1.0.0
- [Scoverage] 1.1.0

## Installation ##

Download and copy [sonar-scoverage-plugin-1.1.1.jar] [LatestPluginJar] to the Sonar plugins directory
(usually <SONAR_INSTALLATION_ROOT>/extensions/plugins). Restart Sonar. Be sure that you have also [sonar-scala] plugin installed.

### Support for older versions of Sonar ###

- SonarQube 4.0: Install version 1.0.2 [sonar-scoverage-plugin-1.0.2.jar] [Plugin102Jar].
- SonarQube 3.5.1: Take a look into the [dedicated branch] [Plugin351] or directly [download binary JAR] [Plugin351Jar].

## Configure Sonar runner ##

Set location of the **scoverage.xml** file in the **sonar-project.properties** located in your project's
root directory, e.g.:

    ...
    sonar.scoverage.reportPath=target/scala-2.10/scoverage-report/scoverage.xml
    ...

## Run Scoverage and Sonar runner ##

If your project is based on SBT and you're using [Scoverage plugin for SBT] [sbt-scoverage] you can
generate the Scoverage report by executing following from command line:

    $ sbt clean coverage test

And then run Sonar runner to upload the report to the Sonar server:

    $ sonar-runner

## Run scoverage with Maven

If your project is based on Maven then check [scoverage-maven-plugin].

## Add statement coverage columns ##

To see the actual statement coverage percentage you need to log in to Sonar as admin.
Click **Components** section on the left side, then click **Customize ON** in the top-right corner and then
add **Statement coverage** column.

## Add widget ##

You can also add **Statement coverage widget** to your project's dashboard. Log in to Sonar as admin. Go to
the project dashboard, click **Configure widgets** in the top-right corner, click **Add widget** button in
the **Custom Measures** section. Click **Edit** in the newly added **Custom Measures** widget and choose
**Statement coverage** for **Metric 1**. Click **Save**, **Back to dashboard**. Enjoy.

## Sample project ##

Take a look at a sample SBT multi-module project located in this repository in the `samples` folder.

## Screenshots ##

Project dashboard with Scoverage plugin:
![Project dashboard with Scoverage plugin](/doc/img/01_dashboard.png "Project dashboard with Scoverage plugin")

Multi-module project overview:
![Multi-module project overview](/doc/img/02_detail.png "Multi-module project overview")

Columns with statement coverage, total number of statements and number of covered statements:
![Columns](/doc/img/03_columns.png "Columns")

Source code markup with covered and uncovered lines:
![Source code markup](/doc/img/04_coverage.png "Source code markup")

-## Changelog ##
-
-### 1.1.1 - 06 May 2015 ###
-
-- Upgrade to SonarQube 4.5.4 API
-- Path fixes
-- TO be used together with Scala Sonar plugin
-
-### 1.1.0 - 23 Sep 2014 ###
-
-- Upgrade to SonarQube 4.2 API
-- Upgrade scoverage to 1.1.0
-
-[LatestPluginJar]: https://github.com/RadoBuransky/sonar-scoverage-plugin/releases/download/1.1.1/sonar-scoverage-plugin-1.1.1.jar
-[Plugin102Jar]: https://github.com/RadoBuransky/sonar-scoverage-plugin/releases/download/1.0.2/sonar-scoverage-plugin-1.0.2.jar
-[SonarQube]: http://www.sonarqube.org/ "SonarQube"
-[sonar-scala] https://github.com/SonarCommunity/sonar-scala
-[Scoverage]: https://github.com/scoverage/scalac-scoverage-plugin "Scoverage"
-[sbt-scoverage]: https://github.com/scoverage/sbt-scoverage
-[scoverage-maven-plugin]: https://github.com/scoverage/scoverage-maven-plugin
-[Plugin351]: https://github.com/RadoBuransky/sonar-scoverage-plugin/tree/sonar3.5.1
-[Plugin351Jar]: https://github.com/RadoBuransky/sonar-scoverage-plugin/releases/download/v1.0.2-Sonar3.5.1/sonar-scoverage-plugin-sonar3.5.1-1.0.2.jar
