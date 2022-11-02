package datos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hola.liby03.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListLibreAdapter extends RecyclerView.Adapter<ListLibreAdapter.ViewHolder> {
    private List<ListLibre> mData;
    //declaramos una segunda array que se utilizara para el filtrado
    ArrayList<ListLibre> listado;
    private LayoutInflater mInflater;
    private Context context;

    public ListLibreAdapter(List<ListLibre> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context= context;
        this.mData = itemList;
        listado = new ArrayList<>();
        listado.addAll(mData);
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @NonNull
    @Override
    public ListLibreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardview_libreria, null);
        return new ListLibreAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListLibreAdapter.ViewHolder holder, final int position){
        holder.img1.setImageResource(mData.get(position).getImg());
        holder.nombre.setText(mData.get(position).getNombre());
        holder.numero.setText(mData.get(position).getNumero());
        holder.email.setText(mData.get(position).getEmail());
    }
    //Metodo utilizado para filtrar por el nombre del libro, sin importar si son minusculas o mayusculas
    public void filtrado(final String buscar){
        int longitud = buscar.length();
        if(longitud == 0){
            mData.clear();
            mData.addAll(listado);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<ListLibre> collecion = mData.stream().filter(i -> i.getNombre().toLowerCase().contains(buscar.toLowerCase())).collect(Collectors.toList());
                mData.clear();
                mData.addAll(collecion);
            }else{
                for(ListLibre l: listado){
                    if(l.getNombre().toLowerCase().contains(buscar.toLowerCase())){
                        mData.add(l);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setItems(List<ListLibre> items){mData= items;}

public class ViewHolder extends  RecyclerView.ViewHolder {
    TextView nombre, numero, email;
    ImageView img1;


    ViewHolder(View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.txtNombre);
        numero = itemView.findViewById(R.id.txtnumero);
        email = itemView.findViewById(R.id.txtEmail);
        img1 = itemView.findViewById(R.id.img1);


    }

    public void bindData(ListLibre item) {
        nombre.setText(item.getNombre());
        numero.setText(item.getNumero());
        email.setText(item.getEmail());

    }
}
}
