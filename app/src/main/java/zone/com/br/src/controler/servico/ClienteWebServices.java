package zone.com.br.src.controler.servico;

import com.google.gson.Gson;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import zone.com.br.src.controler.UsuarioDAO;
import zone.com.br.src.model.Usuario;

public class ClienteWebServices implements UsuarioDAO {

    private SoapObject soap;
    private SoapSerializationEnvelope envelope;
    private HttpTransportSE http;
    private Object resposta;

    public ClienteWebServices(){
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        http = new HttpTransportSE("");
    }

    @Override
    public boolean insereUsuario(String usuarioJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "insereUsuario");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("insereUsuario", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")){
            retorno = true;
        }

        return retorno;
    }

    @Override
    public String achaUsuarioPorId(String usuarioJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaUsuarioPorId");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaUsuarioPorId", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public String achaUsuarioPorNome(String usuarioJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaUsuarioPorNome");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaUsuarioPorNome", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public String achaUsuarioPorUsuario(String usuarioJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaUsuarioPorUsuario");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaUsuarioPorUsuario", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public String achaUsuarioPorEndereco(String usuarioJson) throws IOException, XmlPullParserException {
        String retorno;

        soap = new SoapObject("http://WebService", "achaUsuarioPorEndereco");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("achaUsuarioPorEndereco", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();

        return retorno;
    }

    @Override
    public List<Usuario> achaTodosUsuarios() throws IOException, XmlPullParserException {
        Gson json = new Gson();

        String retorno;

        soap = new SoapObject("http://WebService", "achaTodosUsuarios");

        envelope.setOutputSoapObject(soap);

        http.call("achaTodosUsuarios", envelope);

        resposta = envelope.getResponse();
        retorno = resposta.toString();
        UsuarioList usuarios = json.fromJson(retorno, UsuarioList.class);

        return usuarios.getList();
    }

    @Override
    public boolean atualizaUsuario(String usuarioJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "atualizaUsuario");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("atualizaUsuario", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")) {
            retorno = true;
        }

        return retorno;
    }

    @Override
    public boolean deletaUsuario(String usuarioJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "deletaUsuario");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("deletaUsuario", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")) {
            retorno = true;
        }

        return retorno;
    }

    @Override
    public boolean verificaUsuario(String usuarioJson) throws IOException, XmlPullParserException {
        boolean retorno = false;

        soap = new SoapObject("http://WebService", "verificaUsuario");
        soap.addProperty("usuarioJson", usuarioJson);

        envelope.setOutputSoapObject(soap);

        http.call("verificaUsuario", envelope);

        resposta = envelope.getResponse();

        if (resposta.toString().equalsIgnoreCase("true")) {
            retorno = true;
        }

        return retorno;
    }

    class UsuarioList{
        List<Usuario> list;

        List<Usuario> getList() {
            return list;
        }

        void setList(List<Usuario> list) {
            this.list = list;
        }


    }
}
