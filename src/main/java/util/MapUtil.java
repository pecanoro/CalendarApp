package util;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.model.map.LatLng;

public class MapUtil {
	
	public static LatLng getCoord(String city){
		
		Map<String, LatLng> cities = new HashMap<String, LatLng>();
		
		//Andalucía  
        LatLng almeria = new LatLng(36.838976, -2.4610949);
        cities.put("almería", almeria);
        LatLng cadiz = new LatLng(36.5270612, -6.2885962);
        cities.put("cádiz", cadiz);
        LatLng cordoba = new LatLng(37.8881751, -4.7793835);
        cities.put("córdoba", cordoba);
        LatLng granada = new LatLng(37.1773363, -3.5985571);
        cities.put("granada", granada);
        LatLng huelva = new LatLng(37.261421, -6.9447224);
        cities.put("huelva", huelva);
        LatLng jaen = new LatLng(37.767826, -3.790845);
        cities.put("jaén", jaen);
        LatLng malaga = new LatLng(36.721261, -4.4212655);
        cities.put("málaga", malaga);
        LatLng sevilla = new LatLng(37.3880961, -5.9823299);
        cities.put("sevilla", sevilla);
        
        //Aragón
        LatLng huesca = new LatLng(42.137341, -0.410621);
        cities.put("huesca", huesca);
        LatLng teruel = new LatLng(40.341839, -1.103675);
        cities.put("teruel", teruel);
        LatLng zaragoza = new LatLng(41.6487908, -0.8895811);
        cities.put("zaragoza", zaragoza);
        
        //Asturias
        LatLng asturias = new LatLng(43.3619145, -5.8493887);
        cities.put("asturias", asturias);
        
        //Canarias
        LatLng laspalmas = new LatLng(28.1131545, -15.4408832);
        cities.put("las palmas", laspalmas);
        LatLng santacruz = new LatLng(28.4636296, -16.2518467);
        cities.put("santa cruz de tenerife", santacruz);
        
        //Cantabria
        LatLng cantabria = new LatLng(43.4623057, -3.8099803);
        cities.put("cantabria", cantabria);
        
        //Castilla La Mancha
        LatLng albacete = new LatLng(38.994349, -1.8585424);
        cities.put("albacete", albacete);
        LatLng ciudadreal = new LatLng(38.9848295, -3.9273778);
        cities.put("ciudad real", ciudadreal);
        LatLng cuenca = new LatLng(40.0705314, -2.1367192);
        cities.put("cuenca", cuenca);
        LatLng guadalajara = new LatLng(40.63121, -3.162205);
        cities.put("guadalajara", guadalajara);
        LatLng toledo = new LatLng(39.8628316, -4.0273231);
        cities.put("toledo", toledo);
        
      //Castilla y León
        LatLng avila = new LatLng(40.662594, -4.695817);
        cities.put("ávila", avila);
        LatLng burgos = new LatLng(42.3439925, -3.696906);
        cities.put("burgos", burgos);
        LatLng leon = new LatLng(42.5987263, -5.5670959);
        cities.put("león", leon);
        LatLng palencia = new LatLng(42.011121, -4.532032);
        cities.put("palencia", palencia);
        LatLng salamanca = new LatLng(40.9701039, -5.6635397);
        cities.put("salamanca", salamanca);
        LatLng segovia = new LatLng(40.9435626, -4.1130022);
        cities.put("segovia", segovia);		
        LatLng soria = new LatLng(41.76443, -2.463772);
        cities.put("soria", soria);
        LatLng valladolid = new LatLng(41.652251, -4.7245321);
        cities.put("valladolid", valladolid);
        LatLng zamora = new LatLng(41.507326, -5.745313);
        cities.put("zamora", zamora);
		
        //Cataluña
        LatLng barcelona = new LatLng(41.3850639, 2.1734035);
        cities.put("barcelona", barcelona);
        LatLng girona = new LatLng(41.9722077, 2.8198751);
        cities.put("girona", girona);
        LatLng lleida = new LatLng(41.6175899, 0.6200146);
        cities.put("lleida", lleida);
        LatLng tarragona = new LatLng(41.1190191, 1.2452119);
        cities.put("tarragona", tarragona);
		
        //Ciudad de Ceuta
        LatLng ceuta = new LatLng(35.8883838, -5.3246356);
        cities.put("ceuta", ceuta);
        
        //Ciudad de Melilla
        LatLng melilla = new LatLng(35.2922775, -2.9380973);
        cities.put("melilla", melilla);
        
        //Comunidad de Madrid
        LatLng madrid = new LatLng(40.4167754, -3.7037902);
        cities.put("madrid", madrid);
        
        //Comunidad Foral Navarra
        LatLng navarra = new LatLng(42.8116631, -1.6482653);
        cities.put("navarra", navarra);
        
        //Comunidad Valenciana
        LatLng alicante = new LatLng(38.3459963, -0.4906855);
        cities.put("alicante", alicante);
        LatLng castellon = new LatLng(39.9844579, -0.0449499);
        cities.put("castellón", castellon);
        LatLng valencia = new LatLng(39.4699075, -0.3762881);
        cities.put("valencia", valencia);
        
        //Extremadura
        LatLng badajoz = new LatLng(38.8801386,  -6.970166);
        cities.put("badajoz", badajoz);
        LatLng caceres = new LatLng(39.471329,  -6.370961);
        cities.put("cáceres", caceres);
        
        //Galicia
        LatLng coruna = new LatLng(43.3623436,  -8.4115401);
        cities.put("a coruña", coruna);
        LatLng lugo = new LatLng(43.0097384,  -7.5567582);
        cities.put("lugo", lugo);
        LatLng ourense = new LatLng(42.3357893,  -7.863881);
        cities.put("ourense", ourense);
        LatLng pontevedra = new LatLng(42.4298846,  -8.6446202);
        cities.put("pontevedra", pontevedra);
        
        //Illes Balears
        LatLng illesbalears = new LatLng(39.57119,  2.646634);
        cities.put("illes balears", illesbalears);
        
        //La rioja
        LatLng larioja = new LatLng(42.4627195,  -2.4449852);
        cities.put("la rioja", larioja);
        
        //País Vasco
        LatLng alava = new LatLng(42.8498032,  -2.6729997);
        cities.put("araba/álava", alava);
        LatLng bizkaia = new LatLng(43.2566901,  -2.9240616);
        cities.put("bizkaia", bizkaia);
        LatLng gipuzkoa = new LatLng(43.3182663,  -1.9806448);
        cities.put("gipuzkoa", gipuzkoa);
        
        //Región de Murcia
        LatLng murcia = new LatLng(37.992331, -1.1304575);
        cities.put("murcia", murcia);
		
		return cities.get(city.toLowerCase());
		
	}

}
