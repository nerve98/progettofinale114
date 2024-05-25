package com.generation.progettofinale.configuration;

import java.sql.Date;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import com.generation.progettofinale.models.Moto;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Utente;


@Configuration
public class ModelsContext {


    @Bean
    @Scope("prototype")
    public Moto moto(Map<String, String> map) {
        System.out.println("\n\n\nMap keys: "+map.keySet()+"\n\n\n"+map.values()+"\n\n\n");
        Moto m = new Moto();
        Long id = -1L;
        if(map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }

        m.setId(id);
        m.setEuro(map.get("euro"));
        m.setNomeMotore(map.get("nomeMotore"));
        m.setAnnoProduzione(Integer.parseInt(map.get("annoProduzione")));
        m.setMarca(map.get("marca"));
        m.setTipoMoto(map.get("tipoMoto"));
        m.setColoreMoto(map.get("coloreMoto"));
        m.setTarga(map.get("targa"));
        m.setCilindrata(Integer.parseInt(map.get("cilindrata")));
        m.setCapacitaSerbatoio(Integer.parseInt(map.get("capacitaSerbatoio")));
        m.setPotenzaCV(Integer.parseInt(map.get("potenzaCV")));
        m.setPotenzaKV(Integer.parseInt(map.get("potenzaKV")));
        m.setPeso(Double.parseDouble(map.get("peso")));
        m.setAltezzaSella(Double.parseDouble(map.get("altezzaSella")));
        m.setConsumo(Double.parseDouble(map.get("consumo")));
        m.setPrezzo(Double.parseDouble(map.get("prezzo")));
        m.setElettronico(Boolean.parseBoolean(map.get("elettronico")));
        m.setTrasmissioneM(Boolean.parseBoolean(map.get("trasmissioneM")));

        return m;
    }

    @Bean
    @Scope("prototype")
    public Casco casco(Map<String, String> map) {
        Casco c = new Casco();
        Long id = -1L;
        if (map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }
        c.setId(id);
        c.setModello(map.get("modello"));
        c.setNomeCasco(map.get("nomeCasco"));
        c.setVisieraOscurata(Boolean.parseBoolean(map.get("visieraOscurata")));
        c.setColoreCasco(map.get("coloreCasco"));
        c.setPrezzo(Double.parseDouble(map.get("prezzo")));
    
        return c;
    }
    
    
    @Bean
    @Scope("prototype")
    public Abbigliamento abbigliamento(Map<String, String> map) {
        Abbigliamento a = new Abbigliamento();
        Long id = -1L;
        if (map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }
        a.setId(id);
        a.setNomeAbbigliamento(map.get("nomeAbbigliamento"));
        a.setColoreAbbigliamento(map.get("coloreAbbigliamento"));
        a.setMateriale(map.get("materiale"));
        a.setBrand(map.get("brand"));
        a.setProtezione(Boolean.parseBoolean(map.get("protezione")));
        a.setPrezzo(Double.parseDouble(map.get("prezzo")));

        return a;
    }
    
    @Bean
    @Scope("prototype")
    public Utente newUtente() {
        return new Utente();
    }
    @Bean
    @Scope("prototype")
    public Immagini immagini(Map<String, String> map) {
        Immagini i = new Immagini();
        Long id = -1L;
        Long moto = 0L;
        Long casco = 0L;
        Long abbigliamento = 0L;
        if (map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }
        i.setId(id);
        i.setNome(map.get("nome"));
        i.setUrl(map.get("url"));


        if (map.containsKey("idMoto") && map.get("idMoto")!=null && !map.get("idMoto").isEmpty()) {
            moto = Long.parseLong(map.get("idMoto"));
            i.setIdMoto(moto);
        }
        else if (map.containsKey("idCasco") && map.get("idCasco")!=null && !map.get("idCasco").isEmpty()){
            casco = Long.parseLong(map.get("idCasco"));
            i.setIdCasco(casco);
        }
        else if (map.containsKey("idAbbigliamento") && map.get("idAbbigliamento")!=null && !map.get("idAbbigliamento").isEmpty()){
            abbigliamento = Long.parseLong(map.get("idAbbigliamento"));
            i.setIdAbbigliamento(abbigliamento);
        }
        System.out.println("oggetto incriminato:"+i.toString()+"\n");
        return i;
    }
    

    @Bean
    @Scope("prototype")
    @Primary
    public Utente utente(Map<String, String> map) {
        Utente u = new Utente();
        Long id = -1L;
        if (map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }
        u.setId(id);
        u.setUsername(map.get("username"));
        u.setNome(map.get("nome"));
        u.setCognome(map.get("cognome"));
        u.setEmail(map.get("email"));
        u.setPassword(map.get("password"));
        u.setNumeroCellulare(map.get("numeroCellulare"));
        u.setDataNascita(Date.valueOf(map.get("dataNascita")));
        u.setAdmin(Boolean.parseBoolean(map.get("admin")));

        return u;
    }
}