package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import model.ComunidadAutonoma;
import model.Festivos;
import model.FestivosCCAA;
import model.FestivosNacionales;
import model.Localidad;
import model.Provincia;

import util.DateUtil;
import util.LoadEntities;
import util.MapUtil;


@ManagedBean(name = "calendarBean")
@ViewScoped
public class CalendarBean {
	
    private Date selectedDate;
    private Integer days;
    private String ca;
    private String city;
    private String suburb;
    private String search;
    private Integer option1;
    private Integer option2;
    private Integer type;
    private Boolean disabled;
    private Boolean itemDisabled;
    
    private MapModel simpleModel;
    private String centered;
    
    private Map<String, String> types;
    
	private List<ComunidadAutonoma> ccaaL;
    private List<String> ccaaStringL;
    private List<String> citiesStringL;
    private List<String> suburbsStringL;
    
    private String holidays;
    private Date currentSelectedDate;
    
    private List<Localidad> municipalities;
    private List<String> municipalitiesStringL;
    
    private ComunidadAutonoma com;
    private Provincia pro;
    private Localidad loc;
    
    private Date finalDate;
    
    public CalendarBean() {
    	
		types = new HashMap<String, String>();
		holidays = "\"\"";
		
		selectedDate = new Date();
		currentSelectedDate = new Date();
		
		//Center map Madrid
		simpleModel = new DefaultMapModel();
		centered = "40.41669, -3.700346";
		
		types.put("Días", "1");
		days=0;
		disabled = true;
		itemDisabled = true;
		
		LoadEntities.createFactory();
		
		//Prepare the lists
		suburbsStringL = new LinkedList<String>();
		citiesStringL = new LinkedList<String>();
		ccaaStringL = new LinkedList<String>();
		
		//Obtain all the communities adding them to the list
		LoadEntities.createFactory();
		ccaaL = LoadEntities.findAllCommunities();
		for(ComunidadAutonoma x : ccaaL){
			ccaaStringL.add(x.getComunidadAutonoma());
		}
		
		//Obtain all municipalities for the autocomplete
		municipalities = LoadEntities.findAllMunicipalities();
		municipalitiesStringL = new LinkedList<String>();
		for(Localidad l : municipalities){
			municipalitiesStringL.add(l.getLocalidad());
		}

	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getItemDisabled() {
		return itemDisabled;
	}

	public void setItemDisabled(Boolean itemDisabled) {
		this.itemDisabled = itemDisabled;
	}

	public String getHolidays() {
		return holidays;
	}

	public Map<String, String> getTypes() {
		return types;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public List<ComunidadAutonoma> getCcaaL() {
		return ccaaL;
	}

	public List<String> getCcaaStringL() {
		return ccaaStringL;
	}

	public List<String> getCitiesStringL() {
		return citiesStringL;
	}

	public List<String> getSuburbsStringL() {
		return suburbsStringL;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public List<Localidad> getMunicipalities() {
		return municipalities;
	}

	public List<String> getMunicipalitiesStringL() {
		if(municipalitiesStringL==null){
			municipalitiesStringL = new LinkedList<String>();
			for(Localidad l : municipalities){
				municipalitiesStringL.add(l.getLocalidad());
			}
		}
		return municipalitiesStringL;
	}

	public Date getSelectedDate() {  
        return selectedDate;  
    }  
  
    public void setSelectedDate(Date selectedDate) {  
        this.selectedDate = selectedDate;  
    }

	public Date getCurrentSelectedDate() {
		return currentSelectedDate;
	}

	public void setCurrentSelectedDate(Date currentSelectedDate) {
		this.currentSelectedDate = currentSelectedDate;
	}

	public String getCentered() {
		return centered;
	}

	public void setCentered(String centered) {
		this.centered = centered;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getOption1() {
		return option1;
	}

	public void setOption1(Integer option1) {
		this.option1 = option1;
	}

	public Integer getOption2() {
		return option2;
	}

	public void setOption2(Integer option2) {
		this.option2 = option2;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
// ------------------------------------------- //
//                   HANDLER				   //
//-------------------------------------------- //

	public void handleCCAAChange(){
		
		citiesStringL.clear();
		suburbsStringL.clear();
		holidays = "\'\'";
		
	    if(ca !=null && !ca.equals("")){
	    	com = LoadEntities.findCommunityByName(ca);
	    	List<Provincia> proList = LoadEntities.findAllCities(com);
	    	for(Provincia x : proList){
	    		citiesStringL.add(x.getProvincia());
			}  
		}
	}
	
	public void handleCityChange(){

		suburbsStringL.clear();
		holidays = "\'\'";
		
	    if(city !=null && !city.equals("")){ 	
//	    	simpleModel.addOverlay(new Marker(MapUtil.getCoord(city), city));
//	    	centered = MapUtil.getCoord(city).getLat() + ", " + MapUtil.getCoord(city).getLng();
	    	
	    	pro = LoadEntities.findCityByName(city);
	    	List<Localidad> locList = LoadEntities.findAllMunicipalities(pro);
	    	for(Localidad x : locList){
	    		suburbsStringL.add(x.getLocalidad());
			}
		}
	}
	
	public void handleTypeOfDate(){
		
		if(option2==3 || option2==2 || option2==4){
			types.clear();
			types.put("Días", "1");
			setDisabled(true);
		}
		else {
			types.clear();
			types.put("Meses", "2");
			types.put("Años", "3");
			setDisabled(false);
		}
	
	}
	
	public void handleTypeOfProcedure(){
		
		if(option1==1){
			setItemDisabled(false);
		}
		else {
			setItemDisabled(true);
		}
	
	}
	
	@SuppressWarnings("deprecation")
	public void handleGetHolidays(){
		
		com = LoadEntities.findCommunityByName(ca);
		pro = LoadEntities.findCityByName(city);
		loc = LoadEntities.findMunicipalityByName(suburb);
		
		List<Festivos> aux = LoadEntities.findHolidayByPlace(com, pro, loc);
		List<FestivosNacionales> auxNacionales = LoadEntities.findHolidayNational();
		List<FestivosCCAA> auxCCAA = LoadEntities.findHolidayCCAA(com);
		
		holidays = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		for(Festivos f: aux){
			String fechaConFormato = formato.format(f.getFestivo());
			System.out.println(fechaConFormato);
			
			holidays+=fechaConFormato+"-"+f.getIdTipoFestivo().getTipoFestivo()+", ";
		}
		for(FestivosNacionales fN : auxNacionales){
			String fechaConFormato = formato.format(fN.getFestivo());
			System.out.println(fechaConFormato);
			
			holidays+=fechaConFormato+"-"+fN.getIdTipoFestivo().getTipoFestivo()+", ";			
		}
		for(FestivosCCAA fCA : auxCCAA){
			String fechaConFormato = formato.format(fCA.getFestivo());
			System.out.println(fechaConFormato);
			
			holidays+=fechaConFormato+"-"+fCA.getIdTipoFestivo().getTipoFestivo()+", ";			
		}
		holidays = holidays.substring(0, holidays.length()-2);		
		holidays = "'"+holidays+"'";
		
		currentSelectedDate.setDate(selectedDate.getDate());
		currentSelectedDate.setMonth(selectedDate.getMonth());
		currentSelectedDate.setYear(selectedDate.getYear());
		
	}
	
	public void handleSearchChange(){
		
		if(municipalitiesStringL.contains(search)){
			
			
			System.out.println("search value "+search);
			
			loc = LoadEntities.findMunicipalityByName(search);
			
			pro = loc.getIdProvincia();
			com = pro.getIdComunidadAutonoma();
			
			
			ca = com.getComunidadAutonoma();
			city = pro.getProvincia();
			suburb = loc.getLocalidad();
			
			System.out.println("localidad: "+ suburb);
			System.out.println("provincia: " + city);
			System.out.println("ccaa: " + ca);
			
			
			handleCCAAChange();
			handleCityChange();
			handleGetHolidays();

		}
		
		
	}
	

// ------------------------------------------- //
//                 CONTROLLER				   //
// ------------------------------------------- //
	
	
	/**
	 * Calculate the day with the user options
	 */
	public void calculateCalendar(){
		
		Date res;
		
		com = LoadEntities.findCommunityByName(ca);
		pro = LoadEntities.findCityByName(city);
		loc = LoadEntities.findMunicipalityByName(suburb);
		
		if(ca==null || ca=="" || city==null || city=="" || suburb==null || suburb==""){
			res = new Date();
			return;
		}
		
		// Judicial Deadline
		if(option1==1){
			if(option2==3){
				res = calculateCalendarDays(selectedDate, days, true);
			}
			else if(option2==2) {
				res = calculateWorkingDays(selectedDate, days, true);
			}
			else if(option2==4){
				res = calculateWorkingDaysPlusAugust(selectedDate, days);
			}
			else {
				res = calculateDateToDate(selectedDate, days, true);
			}
		}
		// Administrative Deadline
		else {
			if(option2==3){
				res = calculateCalendarDays(selectedDate, days, false);
			}
			else if(option2==2) {
				res = calculateWorkingDays(selectedDate, days, false);
			}
			else {
				res = calculateDateToDate(selectedDate, days, false);
			}
		}
		
		setFinalDate(res);
		
	}
	
	
	private Date calculateWorkingDaysPlusAugust(Date d, Integer da) {
		
		Date res = DateUtil.addDays(d, da);
		Date daux = d;
		daux = DateUtil.addDays(daux, 1);
		
		Integer hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, daux, res).size();
		res = DateUtil.addDays(res, hol);
		
		Date aux = new Date(res.getTime());
		aux = DateUtil.addDays(aux, 1);
		
		Integer weekend = DateUtil.numberOfWeekendDays(res, daux);
		res = DateUtil.addDays(res, weekend);
		
		hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
		res = DateUtil.addDays(res, hol);
		
		weekend = DateUtil.numberOfWeekendDays(res, aux);
		while(weekend>0){
			aux = DateUtil.addDays(res, 1);
			res = DateUtil.addDays(res, weekend);
			hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
			res = DateUtil.addDays(res, hol);
			weekend = DateUtil.numberOfWeekendDays(res, aux);
		}
		
		while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkWeekend(res) || DateUtil.checkJudicial(res)){
			res = DateUtil.addDays(res, 1);
		}
		
		return res;
	}

	/**
	 * Use this method when the option for Working Days is enable
	 */
	@SuppressWarnings("deprecation")
	public Date calculateWorkingDays(Date d, Integer da, Boolean judicial){
		
		Date res = DateUtil.addDays(d, da);
		Date daux = d;
		daux = DateUtil.addDays(daux, 1);
		
		if(judicial){
			
			Integer hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, daux, res).size();
			res = DateUtil.addDays(res, hol);
			
			Date aux = new Date(res.getTime());
			aux = DateUtil.addDays(aux, 1);
			
			Integer weekend = DateUtil.numberOfWeekendDays(res, daux);
			res = DateUtil.addDays(res, weekend);
			
			hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
			res = DateUtil.addDays(res, hol);
			
			weekend = DateUtil.numberOfWeekendDays(res, aux);
			while(weekend>0){
				aux = DateUtil.addDays(res, 1);
				res = DateUtil.addDays(res, weekend);
				hol = LoadEntities.findHolidayBetweenJud(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
				res = DateUtil.addDays(res, hol);
				weekend = DateUtil.numberOfWeekendDays(res, aux);
			}
			
			if(d.getMonth()<7 && res.getMonth()>=7){
				Date d1 = new Date();
				d1.setDate(1);
				d1.setMonth(7);
				d1.setYear(d.getYear());
				
				Date d2 = new Date();
				d2.setDate(31);
				d2.setMonth(7);
				d2.setYear(d.getYear());
				
				
				Integer sum = DateUtil.numberOfWorkingDaysIn(7,res, com, pro, loc) - LoadEntities.findHolidayBetweenJud(com, pro, loc, d1, d2).size();
				res=this.calculateWorkingDays(res, sum, true);
			}
			
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkWeekend(res) || DateUtil.checkJudicial(res)){
				res = DateUtil.addDays(res, 1);
			}
			
		}
		else{
			
			Integer hol = LoadEntities.findHolidayBetweenAdmin(com, pro, loc, daux, res).size();
			res = DateUtil.addDays(res, hol);
			
			Date aux = new Date(res.getTime());
			aux = DateUtil.addDays(aux, 1);
			
			Integer sunday = DateUtil.numberOfSundays(res, daux);
			res = DateUtil.addDays(res, sunday);
			
			hol = LoadEntities.findHolidayBetweenAdmin(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
			res = DateUtil.addDays(res, hol);
			
			sunday = DateUtil.numberOfSundays(res, aux);
			while(sunday>0){
				aux = DateUtil.addDays(res, 1);
				res = DateUtil.addDays(res, sunday);
				hol = LoadEntities.findHolidayBetweenAdmin(com, pro, loc, DateUtil.addDays(aux, -1), res).size();	
				res = DateUtil.addDays(res, hol);
				sunday = DateUtil.numberOfSundays(res, aux);
			}
			
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkSunday(res)){
				res = DateUtil.addDays(res, 1);
			}
		}
		
		return res;
	}
	
	/**
	 * Use this method when the option for simple Calendar Days is enable
	 */
	@SuppressWarnings("deprecation")
	public Date calculateCalendarDays(Date d, Integer da, Boolean judicial){
		
		Date res = DateUtil.addDays(d, da);
		
		if(judicial){
			
			if(res.getMonth()==7){
				res.setMonth(8);
				res.setDate(1);
			}
			
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkWeekend(res) || DateUtil.checkJudicial(res)){
				res = DateUtil.addDays(res, 1);
			}
		}
		else{
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkSunday(res)){
				res = DateUtil.addDays(res, 1);
			}
		}
		
		return res;
	}
	
	/**
	 * Use this method when the option for Date to Date is enable
	 */
	@SuppressWarnings("deprecation")
	public Date calculateDateToDate(Date d, Integer da, Boolean judicial){
		
		Date res;
		
		if(type==2){
			res = DateUtil.addMonths(d, da);
		}
		else{
			res = DateUtil.addYears(d, da);
		}
		
		if(judicial){
			
			if(res.getMonth()==7){
				res.setMonth(8);
				res.setDate(1);
			}
			
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkWeekend(res) || DateUtil.checkJudicial(res)){
				res = DateUtil.addDays(res, 1);
			}
			
		}
		else{
			while(LoadEntities.checkHoliday(com, pro, loc, res) || DateUtil.checkSunday(res)){
				res = DateUtil.addDays(res, 1);
			}
		}
		
		return res;
	}
	
	/**
	 * completeLocalidad. Complete a Municipality with a given substring
	 */
	
	public List<String> completeLocalidad(String query) { 
		
        List<String> results = new ArrayList<String>();  
        
        for (String s : this.getMunicipalitiesStringL()) {  
        	if(s.toLowerCase().startsWith(query.toLowerCase())){
        		results.add(s);
        	}
        }  
          
        return results;  
    } 

}
