package lazy.juan.morphefied;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class GameActivity extends Activity {
    static String[] names = new String[]{"Frenz and Excelsa",
            "Greg and Ruth",
            "Frenz and Excelsa",
            "Joy and Meds",
            "Lyzel and Alvin",
            "Joy and Frenz",
            "Ariel and Ryan",
            "Ariel and John Paul",
            "Jemil and Lyzel",
            "Lyzel and Morella",
            "Philip and Cedric",
            "Cedrick and Jonathan",
            "Ariel and Excelsa",
            "John Paul and Morella",
            "Lyzel and Excelsa",
            "Ryan and Excelsa",
            "John Paul and Carl",
            "Alvin and Ryan",
            "John Paul and Ariel",
            "Philip and Meds",
            "Alvin and Excelsa",
            "Greg and Joy",
            "John Paul and Alvin",
            "Ruth and Jemil",
            "Joy and Excelsa",
            "John Paul and Jonathan",
            "John Paul and Excelsa",
            "Carl and Meds",
            "Cedric and Joy",
            "Frenz and Ruth",
            "Ryan and Lyzel",
            "Greg and Lyzel",
            "Cedric and Frenz",
            "Jemil and Ryan",
            "Alvin and Frenz",
            "Carl and Joy",
            "Philip and Frenz",
            "Philip and Jonathan",
            "John Paul and Jemil",
            "Carl and Philip",
            "Carl and Ruth",
            "Jonathan and Ruth",
            "Carl and Morella",
            "Meds and Cedric",
            "Excelsa and Ruth",
            "Greg and John Paul",
            "Ruth and Lyzel"};
    static int[] images = new int[]{R.drawable.a,
            R.drawable.aa,
            R.drawable.b,
            R.drawable.bb,
            R.drawable.c,
            R.drawable.cc,
            R.drawable.d,
            R.drawable.dd,
            R.drawable.e,
            R.drawable.ee,
            R.drawable.f,
            R.drawable.ff,
            R.drawable.g,
            R.drawable.gg,
            R.drawable.h,
            R.drawable.hh,
            R.drawable.i,
            R.drawable.ii,
            R.drawable.j,
            R.drawable.jj,
            R.drawable.k,
            R.drawable.kk,
            R.drawable.l,
            R.drawable.ll,
            R.drawable.m,
            R.drawable.mm,
            R.drawable.n,
            R.drawable.nn,
            R.drawable.o,
            R.drawable.oo,
            R.drawable.p,
            R.drawable.pp,
            R.drawable.q,
            R.drawable.qq,
            R.drawable.r,
            R.drawable.rr,
            R.drawable.s,
            R.drawable.ss,
            R.drawable.t,
            R.drawable.tt,
            R.drawable.u,
            R.drawable.uu,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final int pos;
            Random rand = new Random();
            pos = rand.nextInt(images.length) + 0;

            View rootView = inflater.inflate(R.layout.fragment_game, container, false);
            Button show = (Button) rootView.findViewById(R.id.btnShow);
            ImageView img = (ImageView) rootView.findViewById(R.id.ivImage);
            img.setImageResource(images[pos]);
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Answer");
                    builder.setMessage(names[pos]);
                    builder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                            getActivity().overridePendingTransition(R.anim.slide_to_right, R.anim.slide_to_right);
                        }
                    });
                    builder.setNegativeButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getFragmentManager().beginTransaction()
                                    .replace(R.id.container, new PlaceholderFragment())
                                    .commit();
                        }
                    });
                    builder.show();
                }
            });
            return rootView;
        }
    }
}
