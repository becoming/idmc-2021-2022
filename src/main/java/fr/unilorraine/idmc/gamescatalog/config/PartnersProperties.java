package fr.unilorraine.idmc.gamescatalog.config;

public class PartnersProperties {
    private static final String TOKEN_URL="https://id.twitch.tv/oauth2/token?client_id=1vamh6dcvc24wxgmc6c8ad7h4v4g81&client_secret=ddaun0njuhiywrxxsd7r96d091xt9k&grant_type=client_credentials";
    private static final String CLIENT_ID = "1vamh6dcvc24wxgmc6c8ad7h4v4g81";

    private PartnersProperties() { throw new IllegalStateException("PartnersProperties class");}

    public static String getTokenUrl(){
        return PartnersProperties.TOKEN_URL;
    }
    public static String getClientID(){
        return PartnersProperties.CLIENT_ID;
    }
}
