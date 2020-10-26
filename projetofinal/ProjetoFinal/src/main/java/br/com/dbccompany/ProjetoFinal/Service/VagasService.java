package br.com.dbccompany.ProjetoFinal.Service;

import br.com.dbccompany.ProjetoFinal.Document.Vagas;
import br.com.dbccompany.ProjetoFinal.Repository.VagasRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VagasService {

    @Autowired
    VagasRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public List<Vagas> consumerApi() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String url = "https://ats.compleo.com.br/oportunidades/DBC/get/json/vagas";
        String response = restTemplate.getForObject(url, String.class);
        List<Vagas> vagas = objectMapper.readValue(response, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, Vagas.class));
        return vagas;
    }

    @Transactional( rollbackFor = Exception.class )
    public List<Vagas> buscarTodos() throws JsonProcessingException {
        List<Vagas> compleo = this.consumerApi();
        List<Vagas> atual = repository.findAll();
        boolean existe = false;

        for (int i = 0; i < compleo.size(); i++) {
            existe=false;
            for (int j = 0; j < atual.size(); j++) {
                if ((atual.get(j).getCodigovaga().equals(compleo.get(i).getCodigovaga()))) {
                    existe = true;
                }
            }
            if(existe==false){
                this.salvarVagas(compleo.get(i));
                atual.add(compleo.get(i));

            }
        }
        for (int i = 0; i < atual.size(); i++) {
            existe=false;
            for (int j = 0; j < compleo.size(); j++) {
                if ((compleo.get(j).getCodigovaga().equals(atual.get(i).getCodigovaga()))) {
                    existe = true;
                }
            }
            if(existe==false){
                this.delete(atual.get(i).getId());
                atual.remove(atual.get(i));
            }
        }

        return atual;
    }

    @Transactional( rollbackFor = Exception.class)
    public Vagas salvarVagas(Vagas vagas){
        return repository.save(vagas);
    }

    @Transactional( rollbackFor = Exception.class)
    public List<Vagas> salvarListaVagas( List<Vagas> vagas ){
        return repository.saveAll(vagas);
    }

    @Transactional( rollbackFor = Exception.class)
    public Vagas editar(Vagas vaga, String id){
        vaga.setId(id);
        return repository.save(vaga);
    }

    public Vagas buscarPoriD(String id ){
        Optional<Vagas> vagas = repository.findById(id);
        return vagas.get();
    }

    public List<Vagas> buscarPorTitulo(String titulo){
        return repository.findByTitulo(titulo);
    }

    public List<Vagas> buscarPorDataDeAbertura(String data){
        return repository.findByDataabertura(data);
    }

    public List<Vagas> buscarPorCodigoDaVaga(String codigo) {
        return repository.findByCodigovaga(codigo);
    }

    public Vagas buscarPorUrl(String url){
        return this.repository.findByUrl(url);
    }

    public List<Vagas> buscarPorCidade(String cidade){
        return this.repository.findByCidade(cidade);
    }

    public List<Vagas> buscarPorEstado(String estado){
        return this.repository.findByEstado(estado);
    }

    public List<Vagas> buscarPorCodigoDaFilial(Integer codigoFilial){
        return this.repository.findByCodigofilial(codigoFilial);
    }

    public List<Vagas> buscarPorNomeDaFilial(String nomeFilial){
        return this.repository.findByNomefilial(nomeFilial);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
