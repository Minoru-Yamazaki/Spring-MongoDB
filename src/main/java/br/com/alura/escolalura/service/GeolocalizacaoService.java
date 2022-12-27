package br.com.alura.escolalura.service;

import br.com.alura.escolalura.model.Contato;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class GeolocalizacaoService {

    public List<Double> getLatLong(Contato contato) throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext().setApiKey("apiKey"); //Colocar a chave da API Google

        GeocodingApiRequest request = GeocodingApi.newRequest(context).address(contato.getEndereco());

        //GeocodingResult[] results = request.await();

        //LatLng location = results[0].geometry.location;

        return Arrays.asList(-23.5217627828645, -46.186503581080636); // location.lat; location.lng
    }
}
