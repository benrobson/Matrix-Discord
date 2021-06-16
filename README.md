![MatrixToDiscord Logo](https://i.imgur.com/xN1APlr.png)

# MatrixToDiscord
Created and Developed by [Ben Robson](https://github.com/benrobson). <br>
Send Matrix event notifications to a Discord channel, useful for staff to monitor players off the Server.

# Setup
- Download the latest build of MatrixToDiscord from the [releases page](https://github.com/benrobson/MatrixToDiscord/releases).
- Put this plugin in your plugins folder (this plugin requires Matrix (duh) and Matrix requires ProtocolLib).
- Launch the Server once and fill in your Discord API token and the channel that the notifications are to be sent.

#config.yml
| Property                  	| Description                                                                              	| Example                      	|
|---------------------------	|------------------------------------------------------------------------------------------	|------------------------------	|
| prefix                    	| A prefix for console messages.                                                           	| '&5&lMatrix&8=>&9Discord&r ' 	|
| server                    	| Name of the server the anticheat has been triggered in (very useful for proxied servers) 	| 'Survival'                   	|
| discordapitoken           	| The Discord API token for your discord bot application.                                  	| 'TOKEN'                      	|
| matrixnotificationchannel 	| The Discord channel for the notifications to appear.                                     	| 'anticheat-logs'             	|