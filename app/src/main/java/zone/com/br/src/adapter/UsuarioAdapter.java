package zone.com.br.src.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zone.com.br.src.R;
import zone.com.br.src.model.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.Adapter> {
    private List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public Adapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_usuarios, viewGroup, false);

        return new Adapter(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter adapter, int i) {
        Usuario usuario = usuarios.get(i);
        adapter.textNome.setText(usuario.getNome());
        adapter.textNick.setText(usuario.getUsername());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class Adapter extends RecyclerView.ViewHolder {
        private TextView textNome;
        private TextView textNick;

        public Adapter(View itemView){
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textNick = itemView.findViewById(R.id.textNick);
        }
    }
}
