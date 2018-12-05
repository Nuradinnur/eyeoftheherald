# Eye of the Herald

A battle-tested, fully-functional, open sourced backend for developers wishing to play with the Riot Games API for the smash-hit video game League of Legends.

Consider it an abstraction layer (with lots of extra features) for the API.

---

#### Usage details

##### Requirements:
* Maven
* MySQL server

There are three small commands to get up and running!

1 - Clone the source files.  

    git clone https://github.com/Nuradinnur/eyeoftheherald.git
    cd eyeoftheherald/
(You can also clone manually if you don't have `git` installed.) 

2 - Edit the property files to properly authenticate against your MySQL database.

Navigate to `src/main/resources/application.properties` and replace `${db.name}` with your database name, `${db.username}` with your MySQL username and `${db.password}` with your password.  

3 - Run the following commands in the root of the project to build and run the JAR file.

    mvn package -e
    cd target
    java -jar eye-of-the-herald-0.1.1-SNAPSHOT.jar
    
    
##### Want to contribute or report a bug?

Create an issue or pull request! 💖

---

#### Summary of all endpoints

Below is a table containing all currently available endpoints in the application.  Every endpoint in this application responds with JSON.  A verbose and more technical recount of all endpoints can be found in the wiki.

##### Data Dragon endpoints:
All endpoints in this category are ordered by the Riot-given game asset ID.  It is suspected that this order is based on game asset release date. 

| URL | Response entity |
| --- | --- |
| `/static/{locale}/champions` | A list of all champions |
| `/static/{locale}/items` | A list of all items |
| `/static/{locale}/runes` | A list of all rune trees, with runes as children of each tree |
| `/static/{locale}/summoner-spells` | A list of all summoner spells |
| `/static/{locale}/summoner-icons` | A list of all summoner profile icons |

##### Riot API wrapping endpoints:

The endpoints in this category require the use of URL variables.  The variable names and variable type are displayed in the below table.

| Variable name | Variable type |
| --- | --- |
| `accountId` | Integer |
| `championId` | Integer |
| `leagueId` | String |
| `queue` | Enumeration (possible values: `RANKED_SOLO_5X5`, `RANKED_FLEX_SR`, `RANKED_FLEX_TT`) |
| `region` | Enumeration (possible values: `br`, `eune`, `euw`, `jp`, `kr`, `lan`, `las`, `na`, `oce`, `tr`, `ru`, `pbe`) |
| `summonerId` | Integer |
| `summonerName` | String  |


| URL | Response entity |
| --- | --- |
| `/api/{region}/summoner/{summonerName}/by-name` | Summoner/account information for a given summoner name |
| `/api/{region}/summoner/{accountId}/by-account-id` | Summoner/account information for a given account ID |
| `/api/{region}/summoner/{summonerId}/by-summoner-id` | Summoner/account information for a given summoner ID |
| `/api/{region}/summoner/{summonerId}/mastery` | A list of all mastery scores for a given summoner |
| `/api/{region}/summoner/{summonerId}/mastery/{championId}` | A mastery score for a given summoner playing a given champion |
| `/api/{region}/summoner/{summonerId}/mastery/score` | The total mastery score for a given summoner |
| `/api/{region}/summoner/{accountId}/matches` | A list of matches for a given summoner |
| `/api/{region}/summoner/{summonerId}/leagues` | Ranked information for a given summoner |
| `/api/{region}/summoner/{summonerId}/spectate` | Spectator information for a given summoner who is currently in a game |
| `/api/{region}/rotation` | A list of champions that are currently free-to-play |
| `/api/{region}/league/{leagueId}` | Player and ranking information for a given ranked league |
| `/api/{region}/league/master/{queue}` | A list of players currently ranked Master for a given queue |
| `/api/{region}/league/challenger/{queue}` | A list of players currently ranked Challenger for a given queue |
| `/api/{region}/service-status` | League of Legends service status |
| `/api/{region}/match/{matchId}` | The result and performance statistics for a given match  |
| `/api/{region}/match/{matchId}/timeline` | Timestamped event data from a given match |
| `/api/{region}/featured-games` | The list of featured games promoted in the client |
| `/api/{region}/verification/{summonerId}` | A verification system allowing for the identification of users' summoner names |

---

#### Why should I use this as my backend?
Eye of the Herald (EotH) will provide a one-stop-shop API wrapper and/or endpoints, written in Java and Spring.  From rate limiting to producing clean and ready to use objects, it aims to be a very extendable and very secure foundation for your stack.

It also comes with persistence, a crawling algorithm (with customization coming in the future) and Data Dragon support.  Future goals include machine learning using DL4J (a very powerful open sourced deep learning library), data analyses methods and more.

Currently, there is a lot of work to be done, and many things are broken, but expect frequent updates.  At the rate the project has been progressing, there should be significant work done by February or so.  By then, the application should be production ready and secure.

**Note:** you don't have to be a Java developer to make use of this application!  Once the core components are complete, developers can customize the behaviour of the application via configuration files, run the application and simply call its endpoints *in any language they wish*.

---

#### Current features:
* Data Dragon (static game data) support
* Wrapped, easy-to-use API access
    * DTOs retrieved from the Riot Games API
    * Rate limiting (Using a modified version of the [Token Bucket algorithm](https://en.wikipedia.org/wiki/Token_bucket))
* Basic crawling algorithm 
* Persistence
    * DTO-to-persistent-entity converters (mappers)
    
#### Upcoming features:
* Persistence
    * Immutability in entity objects (Objects represent game state and should *not* change)
    * Caching of frequently pulled data
    * Spring repositories
    * Pagination and sorting of responses
* Statistics
    * Spring queries to provide basic, but very insightful statistics, i.e.: *Morgana, in winning matches, averages a KDA of 5.7 / 2.9 / 12.6*
    * Machine learning algorithms allowing answers to very open questions, i.e.: *For a certain strategy and build, what will my win rate be?*
* Customizability
    * Crawler algorithm strategies, speeds, persistence/transience, et cetera
    * Caching strategies used
    * Central configuration file
* Security
    * Limit all controller requests to specific hosts
    * API key security (A necessary requirement in obtaining a production API key)
* Want more?
    * Feel free to leave an issue or pull request if you want to contribute your ideas!

---

#### Backend architecture

A lot of thought has been put into the application architecture.  The data pipeline has been carefully designed so as to provide:

1. Removal of defunct properties and data types
2. Clean and readily recognizable objects and child properties
3. Integration with static Data Dragon definitions and images
4. Persistence, abstracted from the rest of the application
5. Efficient rate limiting per region
6. Performance, both computationally and memory-wise

A flow chart, below, depicts each major step in the data pipeline during an example scenario.

##### A request is made for a particular summoner's match history
The request is echoed down to the Data Interface.  The interface requests the Rate Limiter for permission to execute the request.  If the rate limiter declines, the request can either sleep until the rate limiter grants the request, or the request can fail returning an informational `429 Too Many Requests` response.  This strategy will be configurable.

`Riot API <------ Rate Limiter <------ Data Interface <------ Service <------ Request`

##### The Riot API responds with some JSON
The API returns JSON, which is then mapped to a persistent object.  The object has clean properties with simple and accurate names, and static data types such as `Champions` or `SummonerSpells` are injected.  The objects are then optionally persisted and future requests for the same data (within certain conditions) will be retrieved from the database.  The object is handed back to the service.

`Riot API ------> Data Interface ------> Service <------> Object Mapper / Data Dragon Service`

##### Optional: transformative operations on the objects
In most cases, for example a summoner lookup application, the backend controllers need to provide output composed of data from multiple Riot API endpoints.  Since the data returned is very verbose, optional processing of the data will need to be done so that a user of the application does not download 8 megabytes of JSON per request.  Multiple transformation layers might be required.

`Service ------> 1-N Transformation Layers ------> Controllers`
