package com.generation.progettofinale.configuration;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.generation.progettofinale.models.Moto;
import com.generation.progettofinale.models.Casco;
import com.generation.progettofinale.dao.DaoAbbigliamento;
import com.generation.progettofinale.dao.DaoCasco;
import com.generation.progettofinale.dao.DaoImmagini;
import com.generation.progettofinale.dao.DaoMoto;
import com.generation.progettofinale.dao.DaoUtente;
import com.generation.progettofinale.models.Abbigliamento;
import com.generation.progettofinale.models.Immagini;
import com.generation.progettofinale.models.Utente;


@Configuration
public class ModelsContext {
    @Autowired
    private DaoMoto daoMoto;
    @Bean
    @Scope("prototype")
    public Moto moto(Map<String, String> map) {
        Moto m = new Moto();
        Long id = -1L;
        Long moto = 0L;
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
        if(map.containsKey("id_moto")) {
            moto = Long.parseLong(map.get("id_moto"));
        }
        


        return m;
    }

    @Autowired
    private DaoCasco casco;
    
    @Bean
    @Scope("prototype")
    public Casco casco(Map<String, String> map) {
        Casco c = new Casco();
        Long id = -1L;
        Long casco = 0L;
        if (map.containsKey("id")) {
            id = Long.parseLong(map.get("id"));
        }
        c.setId(id);
        c.setModello(map.get("modello"));
        c.setNomeCasco(map.get("nomeCasco"));
        c.setVisieraOscurata(Boolean.parseBoolean(map.get("visieraOscurata")));
        c.setColoreCasco(map.get("coloreCasco"));
        c.setPrezzo(Double.parseDouble(map.get("prezzo")));
        if (map.containsKey("idCasco")) {
            casco = Long.parseLong(map.get("idCasco"));
        }
        
        return c;
    }

        @Autowired
        private DaoAbbigliamento daoAbbigliamento;
        @Bean
        @Scope("prototype")
        public Abbigliamento abbigliamento(Map<String, String> map) {
            Abbigliamento a = new Abbigliamento();
            Long id = -1L;
            Long abbigliamento = 0L;
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
            if (map.containsKey("idAbbigliamento")) {
                abbigliamento = Long.parseLong(map.get("idAbbigliamento"));
            }
            return a;
        }

        @Autowired
        private DaoImmagini daoImmagini;
        @Bean
        @Scope("prototype")
        public Immagini immagini(Map<String, String> map) {
            Immagini i = new Immagini();
            Long id = -1L;
            Long immagini = 0L;
            if (map.containsKey("id")) {
                id = Long.parseLong(map.get("id"));
            }
            i.setId(id);
            i.setNome(map.get("nome"));
            i.setUrl(map.get("url"));
            if (map.containsKey("idMoto") && map.get("idMoto") != null) {
                immagini = Long.parseLong(map.get("idMoto"));
                i.setIdMoto(immagini);
            }
            else if (map.containsKey("idCasco") && map.get("idCasco") != null){
                immagini = Long.parseLong(map.get("idCasco"));
                i.setIdCasco(immagini);
            }
            else if (map.containsKey("idAbbigliamento") && map.get("idAbbigliamento") != null){
                immagini = Long.parseLong(map.get("idAbbigliamento"));
                i.setIdAbbigliamento(immagini);
            }
            return i;
        }
        @Autowired
        private DaoUtente daoUtente;
        @Bean
        @Scope("prototype")
        public Utente utente(Map<String, String> map) {
            Utente u = new Utente();
            Long id = -1L;
            Long utente = 0L;
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
            u.setAdmin(Boolean.parseBoolean(map.get("isAdmin")));
            if (map.containsKey("idUtente")) {
                utente = Long.parseLong(map.get("idUtente"));
            }
            return u;
        }


    
}

