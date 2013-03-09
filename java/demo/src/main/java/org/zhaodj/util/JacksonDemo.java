package org.zhaodj.util;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JacksonDemo {
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper=new ObjectMapper();
		String json = "[{\"uid\":474496494,\"tinyurl\":\"http://hdn.xnimg.cn/photos/hdn121/20120806/1845/tiny_Uo9h_77a8000039131375.jpg\",\"vip\":1,\"sex\":1,\"name\":\"兆君\",\"star\":0,\"headurl\":\"http://hdn.xnimg.cn/photos/hdn321/20120806/1845/h_head_z6nJ_68e2000001a81375.jpg\",\"zidou\":0}]";
		JsonNode node=mapper.readValue(json, JsonNode.class);
		System.out.println(node.path(0).path("uid").getLongValue());
		json="{\"ids\":[2115302210,2887339314,1721825977,1266321801,2769285367,1195031270,1494848464,1304194202,1961294534,1882579600,1748374882,1880121815,2766483817,1933324977,2577139143,1401880315,1134424202,2758197137,1641287674,1697161012,2464213930,1811148004,2717844351,1480927110,1773655610,2093492691,1494720324,1189591617,1220291284,1743951792,1661307294,1647382232,1915508822,1686207710,1781379945,2388714105,10503,2315608862,1951657750,2264489285,1786226457,1912400821,1841700611,2179565352,1678325381,1296492473,1400314314,2129867007,1917369903,2485697323,1629756430,1191258123,1641417650,1287469391,1558247760,1645609655,1749127163,1708942053,1925033535,1763362173,1738690784,2185082815,1649252577,1657236125,1642482194,1704191027,1642471052,1196343093,2654738551,2646569725,1642316384,1678191233,1645854784,1559626111,1073198347,1663418681,1657430300,1652811601,1746602664,1095842491,1733388140,1891924883,2610610957,2126427211,1198251274,1197161814,2142166543,1064649941,1686830902,1497390470,1400854834,1187986757,1813080181,1222394121,1654619934,1614282004,1680313495,2480484737,1870632073,2459473287,1655409957,1640571365,1495169251,1866402485,1697142574,1750070171,1494759712,1577826897,2145291155,1654762921,1560442584,1911313045,1958172255,1746173800,1400220917,2603685292,2525533047,2097181621,1919238487,1641337330,1784501333,1586754994,1712725810,2012107717,2532821922,1938522637,2453456613,1650798740,1662047260],\"next_cursor\":0,\"previous_cursor\":0,\"total_number\":129}";
		node=mapper.readValue(json, JsonNode.class).path("ids");
		for(JsonNode child:node){
			System.out.println(child.toString());
		}
		AlbumViewModel model=new AlbumViewModel();
		model.setName("啊哈哈好");
		System.out.println(mapper.writeValueAsString(model));
		json="{\"users\":[]}";
		JsonNode users=mapper.readValue(json, JsonNode.class).path("users");
		System.out.println(users==null);
		System.out.println(users.isArray());
		System.out.println(users.isNull());
		json="{\"error\":\"invalid_access_token\",\"error_code\":21332,\"request\":\"/2/friendships/friends/bilateral.json\"}";
		users=mapper.readValue(json, JsonNode.class).path("users");
		System.out.println(users==null);
		System.out.println(users.isArray());
		System.out.println(users.isNull());
	}
	
	public static class AlbumViewModel {
		
		private String id;
		private String name;
		private long itemsNum;
		private String cover;
		private boolean guestEditable;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getItemsNum() {
			return itemsNum;
		}
		public void setItemsNum(long itemsNum) {
			this.itemsNum = itemsNum;
		}
		public boolean isGuestEditable() {
			return guestEditable;
		}
		public void setGuestEditable(boolean guestEditable) {
			this.guestEditable = guestEditable;
		}
		public String getCover() {
			return cover;
		}
		public void setCover(String cover) {
			this.cover = cover;
		}

	}


}
